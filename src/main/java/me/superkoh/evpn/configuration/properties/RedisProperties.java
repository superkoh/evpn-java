package me.superkoh.evpn.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KOH on 16/5/18.
 */
@ConfigurationProperties(RedisProperties.REDIS_PREFIX)
public class RedisProperties {

    public static final String REDIS_PREFIX = "evpn.redis";

    private String host = "localhost";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
