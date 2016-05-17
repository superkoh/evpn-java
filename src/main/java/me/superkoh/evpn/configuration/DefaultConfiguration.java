package me.superkoh.evpn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

/**
 * Created by KOH on 16/5/10.
 */
@Configuration
@EnableAsync
public class DefaultConfiguration {

    @Bean(name = "defaultTaskExecutor")
    public ThreadPoolTaskExecutor defaultTaskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(10);
        poolTaskExecutor.setMaxPoolSize(20);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
