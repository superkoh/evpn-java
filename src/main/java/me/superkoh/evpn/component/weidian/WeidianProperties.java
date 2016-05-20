package me.superkoh.evpn.component.weidian;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KOH on 16/5/18.
 */
@ConfigurationProperties(WeidianProperties.WEIDIAN_PREFIX)
public class WeidianProperties {

    public static final String WEIDIAN_PREFIX = "evpn.weidian";

    private String appkey;
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}
