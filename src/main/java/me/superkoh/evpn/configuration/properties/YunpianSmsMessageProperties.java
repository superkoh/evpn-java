package me.superkoh.evpn.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KOH on 16/5/18.
 */
@ConfigurationProperties(YunpianSmsMessageProperties.SMS_PREFIX)
public class YunpianSmsMessageProperties {

    public static final String SMS_PREFIX = "evpn.sms.yunpian";

    private String apikey;

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }
}
