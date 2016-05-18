package me.superkoh.evpn.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by KOH on 16/5/18.
 */
@ConfigurationProperties(EVpnMybatisProperties.MYBATIS_PREFIX)
public class EVpnMybatisProperties extends MybatisProperties {

    public static final String MYBATIS_PREFIX = "evpn.datasource";

}
