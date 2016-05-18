package me.superkoh.evpn.configuration;

import me.superkoh.evpn.component.sms.SmsMessage;
import me.superkoh.evpn.component.sms.YunPianSmsMessage;
import me.superkoh.evpn.configuration.properties.YunpianSmsMessageProperties;
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
