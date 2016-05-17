package me.superkoh.evpn.service;

import me.superkoh.evpn.component.sms.SmsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by KOH on 16/5/12.
 */
@Service
public class SmsService {

    @Autowired
    public SmsMessage smsMessage;

    @Async
    public void sendLoginPasswordBySms(String mobile, String code) {
        smsMessage.sendText(mobile, "【evpn】您的登录密码是:" + code);
    }

    @Async
    public void sendLoginPasswordByVoice(String mobile, String code) {
        smsMessage.sendVoice(mobile, code);
    }
}
