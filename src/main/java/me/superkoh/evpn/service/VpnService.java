package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.entity.Banner;
import me.superkoh.evpn.domain.entity.Server;
import me.superkoh.evpn.domain.entity.ServerConnectCount;
import me.superkoh.evpn.domain.mapper.*;
import me.superkoh.evpn.domain.model.*;
import me.superkoh.evpn.service.entitiy.UserTrafficInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
@Service
public class VpnService {

    private static final long MONTHLY_TRAFFIC_LIMIT = 5 * 1024 * 1024 * 1024L;
    private static final long INIT_MONTHLY_TRAFFIC_LIMIT = 5 * 1024 * 1024L;

    private static HashMap<String, String> nasMapping = new HashMap<>();

    static {
        nasMapping.put("172.31.16.104", "52.69.16.186");
        nasMapping.put("104.131.143.69", "104.131.143.69");
        nasMapping.put("172.31.28.135", "52.196.18.70");
    }

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private NasMapper nasMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private MyRadAcctMapper myRadAcctMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserInfoMapper userInfoMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserBillInfoMapper userBillInfoMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RadCheckMapper radCheckMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RadUserGroupMapper radUserGroupMapper;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private EVpnUserMapper eVpnUserMapper;

    public List<Server> getServerList() {
        List<Nas> nasList = nasMapper.selectByExample(new NasExample());
        List<ServerConnectCount> serverConnectCountList = myRadAcctMapper.selectNasConnectCount();
        HashMap<String, Integer> serverConnectCountMap = new HashMap<>();
        serverConnectCountList.stream().filter(serverConnectCount
                -> nasMapping.containsKey(serverConnectCount.getIp())).forEach(serverConnectCount
                -> serverConnectCountMap.put(nasMapping.get(serverConnectCount.getIp()),
                serverConnectCount.getCnt() * 100));
        List<Server> serverList = new ArrayList<>();
        for (Nas nas : nasList) {
            Server server = new Server();
            server.setName(nas.getShortname());
            server.setIp(nas.getNasname());
            if (serverConnectCountMap.containsKey(nas.getNasname())) {
                server.setCnt(serverConnectCountMap.get(nas.getNasname()));
            }
            serverList.add(server);
        }
        return serverList;
    }

    public List<Banner> getBannerList() {
        List<Banner> bannerList = new ArrayList<>();
        Banner banner = new Banner();
        banner.setAsset("http://img.117go.com/timg/upload/160417/4HFVvSal2gDgE3Hp.jpg");
        banner.setLink("http://travelid.cn/?refer=evpn");
        bannerList.add(banner);
        return bannerList;
    }

    public boolean isTrafficOverLimit(String username) {
        Long usage = myRadAcctMapper.selectMonthlyTrafficUsage(username);
        return null != usage && usage > MONTHLY_TRAFFIC_LIMIT;
    }

    public RadCheck getUserAuthByName(String username) {
        RadCheckExample example = new RadCheckExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<RadCheck> radCheckList = radCheckMapper.selectByExample(example);
        if (radCheckList.size() == 1) return radCheckList.get(0);
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public RadCheck createNewUser(String username) {
        Date now = new Date();

        EVpnUser eVpnUser = this.getVpnUser(username);
        if (null == eVpnUser) {
            this.createEVpnUser(username);
        }

        RadCheck radCheck = new RadCheck();
        radCheck.setUsername(username);
        radCheck.setAttribute("User-Password");
        radCheck.setOp(":=");
        radCheck.setValue(DigestUtils.md5Hex(username));
        radCheckMapper.insertSelective(radCheck);

        RadUserGroup radUserGroup = new RadUserGroup();
        try {
            radUserGroup.setUsername(username);
            radUserGroup.setGroupname("user");
            radUserGroup.setPriority(0);
            radUserGroupMapper.insertSelective(radUserGroup);
        } catch (Exception e) {
            radCheckMapper.deleteByPrimaryKey(radCheck.getId());
            throw e;
        }

        UserInfo userInfo = new UserInfo();
        try {
            userInfo.setUsername(username);
            userInfo.setChangeuserinfo("0");
            userInfo.setCreationdate(now);
            userInfo.setCreationby("administrator");
            userInfoMapper.insertSelective(userInfo);
        } catch (Exception e) {
            radCheckMapper.deleteByPrimaryKey(radCheck.getId());
            RadUserGroupExample example = new RadUserGroupExample();
            example.createCriteria().andUsernameEqualTo(username);
            radUserGroupMapper.deleteByExample(example);
            throw e;
        }

        try {
            UserBillInfo userBillInfo = new UserBillInfo();
            userBillInfo.setUsername(username);
            userBillInfo.setChangeuserbillinfo("0");
            userBillInfo.setCreationdate(now);
            userBillInfo.setCreationby("administrator");
            userBillInfo.setLastbill(now);
            userBillInfo.setNextbill(now);
            userBillInfo.setUpdatedate(now);
            userBillInfoMapper.insertSelective(userBillInfo);
        } catch (Exception e) {
            radCheckMapper.deleteByPrimaryKey(radCheck.getId());
            RadUserGroupExample example = new RadUserGroupExample();
            example.createCriteria().andUsernameEqualTo(username);
            radUserGroupMapper.deleteByExample(example);
            userInfoMapper.deleteByPrimaryKey(userInfo.getId());
            throw e;
        }

        return radCheck;
    }

    @Transactional(readOnly = true)
    public EVpnUser getVpnUser(String username) {
        EVpnUserExample example = new EVpnUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<EVpnUser> user = eVpnUserMapper.selectByExample(example);
        if (user.size() == 1) return user.get(0);
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public EVpnUser createEVpnUser(String username) {
        Date now = new Date();
        EVpnUser eVpnUser = new EVpnUser();
        eVpnUser.setUsername(username);
        eVpnUser.setMonthlyTraffic(INIT_MONTHLY_TRAFFIC_LIMIT);
        eVpnUser.setAwardTraffic(0L);
        eVpnUser.setAwardEndDate(now);
        eVpnUserMapper.insertSelective(eVpnUser);
        return eVpnUser;
    }

    @Transactional(readOnly = true)
    public UserTrafficInfo getRemainTraffic(String username) {
        Date now = new Date();
        EVpnUser user = this.getVpnUser(username);
        UserTrafficInfo trafficInfo = new UserTrafficInfo();
        trafficInfo.totalTraffic = INIT_MONTHLY_TRAFFIC_LIMIT;
        if (user.getAwardEndDate().compareTo(now) > 0) {
            trafficInfo.totalTraffic += user.getAwardTraffic();
        }
        Long usage = myRadAcctMapper.selectMonthlyTrafficUsage(username);
        if (null == usage) {
            usage = 0L;
        }
        trafficInfo.remainTraffic = trafficInfo.totalTraffic - usage;
        if (trafficInfo.remainTraffic < 0) trafficInfo.remainTraffic = 0;
        return trafficInfo;
    }
}
