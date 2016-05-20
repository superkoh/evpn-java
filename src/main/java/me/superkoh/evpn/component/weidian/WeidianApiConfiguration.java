package me.superkoh.evpn.component.weidian;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by KOH on 16/5/18.
 */
@Configuration
@EnableConfigurationProperties(WeidianProperties.class)
public class WeidianApiConfiguration {

    @Autowired
    private WeidianProperties weidianProperties;

    @Bean
    public WeidianApi weidianApi(RestTemplate restTemplate, ObjectMapper objectMapper) {
        WeidianApi weidianApi = new WeidianApi(weidianProperties.getAppkey(), weidianProperties.getSecret());
        weidianApi.setRestTemplate(restTemplate);
        weidianApi.setObjectMapper(objectMapper);
        return weidianApi;
    }
}
