package me.superkoh.evpn.configuration;

import me.superkoh.evpn.component.sms.SmsMessage;
import me.superkoh.evpn.component.sms.YunPianSmsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

/**
 * Created by KOH on 16/5/10.
 */
@Configuration
@EnableAsync
@PropertySource("classpath:/sms/sms-${spring.profiles.active}.properties")
public class DefaultConfiguration {

    @Autowired
    private Environment env;

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

    @Bean
    public SmsMessage smsMessage(RestTemplate restTemplate) {
        YunPianSmsMessage smsMessage = new YunPianSmsMessage(env.getProperty("sms.yunpian.apikey"), restTemplate());
        return smsMessage;
    }
}
