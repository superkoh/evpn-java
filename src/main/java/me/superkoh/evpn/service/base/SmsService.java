package me.superkoh.evpn.service.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by KOH on 16/5/12.
 */
abstract public class  SmsService {

    protected static final Logger logger = LoggerFactory.getLogger("smsLogger");

    abstract public void send(String mobile, String content);

    public void sendLoginPassword(String mobile, String code) {
        this.send(mobile, "【evpn】您的登录密码是:" + code);
    }
}
