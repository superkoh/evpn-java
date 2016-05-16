package me.superkoh.evpn.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.domain.mapper.evpn.FreeUserMapper;
import me.superkoh.evpn.domain.mapper.evpn.MobileValidationCodeMapper;
import me.superkoh.evpn.domain.mapper.evpn.VipUserMapper;
import me.superkoh.evpn.domain.mapper.evpn.VipUserTokenMapper;
import me.superkoh.evpn.domain.mapper.radius.RadCheckMapper;
import me.superkoh.evpn.domain.model.evpn.FreeUser;
import me.superkoh.evpn.domain.model.evpn.MobileValidationCode;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.domain.model.evpn.VipUserToken;
import me.superkoh.evpn.domain.model.radius.RadCheck;
import me.superkoh.evpn.exception.BizException;
import me.superkoh.evpn.service.entity.VipUserWithToken;
import me.superkoh.evpn.service.base.SmsService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by KOH on 16/4/21.
 */
@Service
public class UserService {

    @Autowired
    private RadCheckMapper radCheckMapper;

    @Autowired
    private FreeUserMapper freeUserMapper;

    @Autowired
    private MobileValidationCodeMapper mobileValidationCodeMapper;

    @Autowired
    private VipUserMapper vipUserMapper;

    @Autowired
    private VipUserTokenMapper vipUserTokenMapper;

    @Autowired
    private Jedis jedis;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("yunpianSmsService")
    private SmsService smsService;

    @Transactional(readOnly = true, transactionManager = "radiusTransactionManager")
    public RadCheck getConnInfoByDevice(String vd) {
        return radCheckMapper.selectByUsername(vd);
    }

    @Transactional(transactionManager = "radiusTransactionManager", rollbackFor = {Exception.class})
    public RadCheck createNewConnInfo(String vd) {
        RadCheck radCheck = new RadCheck();
        radCheck.setUsername(vd);
        radCheck.setAttribute("Cleartext-Password");
        radCheck.setOp(":=");
        radCheck.setValue(DigestUtils.md5Hex(vd));
        radCheckMapper.insert(radCheck);
        return radCheck;
    }

    @Transactional(transactionManager = "radiusTransactionManager", rollbackFor = {Exception.class})
    public RadCheck createConnInfoIfNotExists(String vd) {
        RadCheck radCheck = this.getConnInfoByDevice(vd);
        if (null == radCheck) {
            radCheck = this.createNewConnInfo(vd);
        }
        return radCheck;
    }

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public FreeUser getFreeUserByUserName(String username) {
        return freeUserMapper.selectByUsername(username);
    }

    @Transactional(transactionManager = "eVpnTransactionManager", rollbackFor = {Exception.class})
    public FreeUser createNewFreeUser(String vd) {
        FreeUser user = new FreeUser();
        user.setUsername(vd);
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 15);
        user.setExpireDate(calendar.getTime());
        user.setCreateTime(now);
        freeUserMapper.insert(user);
        return user;
    }

    @Transactional(transactionManager = "eVpnTransactionManager", rollbackFor = {Exception.class})
    public FreeUser createFreeUserIfNotExists(String username) throws Exception {
        FreeUser user = this.getFreeUserByUserName(username);
        if (null == user) {
            user = this.createNewFreeUser(username);
        }
        return user;
    }

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public MobileValidationCode getMobileCode(String mobile) throws IOException {
        String validationCodeStr = jedis.get("send_code_" + mobile);
        MobileValidationCode validationCode;
        if (null == validationCodeStr) {
            validationCode = mobileValidationCodeMapper.getMobileCodeByMobile(mobile);
        } else {
            validationCode = objectMapper.readValue(validationCodeStr, MobileValidationCode.class);
        }
        if (null != validationCode) {
            Date now = new Date();
            if (now.after(validationCode.getExpireTime())) return null;
        }
        return validationCode;
    }


    @Transactional(transactionManager = "eVpnTransactionManager", rollbackFor = {Exception.class})
    public void sendMobileCode(String mobile, String captcha, String vd) throws IOException {
        String expectedCaptcha = jedis.get("login_captcha_" + vd);
        if (null == expectedCaptcha || !expectedCaptcha.toLowerCase().equals(captcha.toLowerCase())) {
            throw new BizException(-1, "验证码错误");
        }
        MobileValidationCode validationCode = this.getMobileCode(mobile);
        if (null == validationCode) {
            validationCode = new MobileValidationCode();
            validationCode.setMobile(mobile);
            int randomCode = RandomUtils.nextInt(1000, 9999);
            validationCode.setCode(String.valueOf(randomCode));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 10);
            validationCode.setExpireTime(calendar.getTime());
            mobileValidationCodeMapper.insert(validationCode);
            jedis.set("send_code_" + mobile, objectMapper.writeValueAsString(validationCode));
            jedis.expire("send_code_" + mobile, 60 * 10);
        }
        smsService.sendLoginPassword(mobile, validationCode.getCode());
    }

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public VipUser getVipUserByMobile(String mobile) {
        return vipUserMapper.selectByMobile(mobile);
    }

    @Transactional(transactionManager = "eVpnTransactionManager", rollbackFor = {Exception.class})
    public VipUserWithToken loginWithMobile(String mobile, String validationCode, String vd) throws Exception {
        Date now = new Date();
        MobileValidationCode expectCode = this.getMobileCode(mobile);
        if (null == expectCode || !expectCode.getCode().equals(validationCode)) {
            throw new BizException(-1, "手机验证码错误");
        }
        FreeUser freeUser = this.createFreeUserIfNotExists(vd);
        VipUser user = this.getVipUserByMobile(mobile);
        if (null == user) {
            user = new VipUser();
            user.setMobile(mobile);
            user.setCreateTime(now);
            user.setExpireDate(freeUser.getExpireDate());
            vipUserMapper.insert(user);
        }
        VipUserToken userToken = new VipUserToken();
        userToken.setVipUserId(user.getId());
        userToken.setToken(UUID.randomUUID().toString());
        userToken.setCreateTime(now);
        vipUserTokenMapper.insert(userToken);
        jedis.set("token_map_" + userToken.getToken(), objectMapper.writeValueAsString(user));
        jedis.expire("token_map_" + userToken.getToken(), 3600 * 24 * 24);
        return new VipUserWithToken(user, userToken);
    }

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public VipUser getVipUserByToken(String token) {
        String redisKey = "token_map_" + token;
        VipUser user;
        try {
            String vipUserStr = jedis.get(redisKey);
            if (null == vipUserStr) {
                user = vipUserMapper.selectByUserToken(token);
                if (null == user) return null;
                jedis.set(redisKey, objectMapper.writeValueAsString(user));
            } else {
                user = objectMapper.readValue(vipUserStr, VipUser.class);
            }
        } catch (Exception e) {
            return null;
        }
        return user;
    }


}