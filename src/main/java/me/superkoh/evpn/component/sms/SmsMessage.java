package me.superkoh.evpn.component.sms;

/**
 * Created by KOH on 16/5/17.
 */
public interface SmsMessage {

    void sendText(String mobile, String content);

    void sendVoice(String mobile, String content);
}
