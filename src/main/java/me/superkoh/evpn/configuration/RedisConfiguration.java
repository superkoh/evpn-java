package me.superkoh.evpn.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import redis.clients.jedis.Jedis;

/**
 * Created by KOH on 16/5/12.
 */
@Configuration
@PropertySource("classpath:/redis/redis-${env:prod}.properties")
public class RedisConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public Jedis jedis() {
        Jedis jedis = new Jedis(env.getProperty("redis.host"));
        return jedis;
    }
}
