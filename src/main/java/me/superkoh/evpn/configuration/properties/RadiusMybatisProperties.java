package me.superkoh.evpn.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KOH on 16/5/18.
 */
@ConfigurationProperties(RadiusMybatisProperties.MYBATIS_PREFIX)
public class RadiusMybatisProperties extends MybatisProperties {

    public static final String MYBATIS_PREFIX = "evpn.radius.datasource";
}
