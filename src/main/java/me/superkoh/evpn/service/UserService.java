package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.mapper.radius.RadCheckMapper;
import me.superkoh.evpn.domain.model.radius.RadCheck;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KOH on 16/4/21.
 */
@Service
public class UserService {

    @Autowired
    private RadCheckMapper radCheckMapper;

    @Transactional(readOnly = true, transactionManager = "radiusTransactionManager")
    public RadCheck getConnInfoByDevice(String vd) {
        return radCheckMapper.selectByUsername(vd);
    }

    @Transactional(transactionManager = "radiusTransactionManager")
    public RadCheck createNewConnInfo(String vd) {
        RadCheck radCheck = new RadCheck();
        radCheck.setUsername(vd);
        radCheck.setAttribute("User-Password");
        radCheck.setOp(":=");
        radCheck.setValue(DigestUtils.md5Hex(vd));
        radCheckMapper.insert(radCheck);
        return radCheck;
    }
}
