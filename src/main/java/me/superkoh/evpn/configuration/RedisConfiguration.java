package me.superkoh.evpn.configuration;

import me.superkoh.evpn.configuration.properties.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Created by KOH on 16/5/12.
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public Jedis jedis() {
        Jedis jedis = new Jedis(redisProperties.getHost());
        return jedis;
    }
}
