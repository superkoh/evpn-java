package me.superkoh.evpn.component.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by KOH on 16/5/18.
 */
@Configuration
@EnableConfigurationProperties(YunpianSmsMessageProperties.class)
public class YunpianSmsMessageConfiguration {

    @Autowired
    private YunpianSmsMessageProperties smsMessageProperties;

    @Bean
    public SmsMessage smsMessage(RestTemplate restTemplate) {
        YunPianSmsMessage smsMessage = new YunPianSmsMessage(smsMessageProperties.getApikey(), restTemplate);
        return smsMessage;
    }
}
