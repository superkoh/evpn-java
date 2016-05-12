package me.superkoh.evpn.service.model.sms;

/**
 * Created by KOH on 16/5/12.
 */
public interface SmsService {

    void send(String mobile, String content);
}
