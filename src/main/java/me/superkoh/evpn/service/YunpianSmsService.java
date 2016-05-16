package me.superkoh.evpn.service;

import me.superkoh.evpn.service.base.SmsService;
import me.superkoh.evpn.service.entity.YunpianSingleSendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by KOH on 16/5/12.
 */
@Component
public class YunpianSmsService extends SmsService {

    private static final String SINGLE_SEND_URL = "https://sms.yunpian.com/v2/sms/single_send.json";

    private static final String APIKEY = "0d186472132307a8a8cea7f7e69ccc6d";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Async
    public void send(String mobile, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("apikey", APIKEY);
        query.add("mobile", mobile);
        query.add("text", content);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(query, headers);
        try {
            ResponseEntity<YunpianSingleSendResponse> responseEntity = restTemplate.exchange(SINGLE_SEND_URL, HttpMethod
                    .POST, httpEntity, YunpianSingleSendResponse.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                YunpianSingleSendResponse response = responseEntity.getBody();
                if (response.code == 0) {
                    logger.info("send sms success: [mobile:{},sid:{}]", response.mobile, response.sid);
                } else {
                    logger.error("send sms error: [mobile:{},msg:{}]", response.mobile, response.msg);
                }
            } else {
                logger.error("send sms error: [mobile:{},content:{},_msg:{}]", mobile, content, responseEntity
                        .getStatusCode().getReasonPhrase());
            }
        } catch (HttpClientErrorException e) {
            logger.error("send sms error: [mobile:{},content:{},_msg{},response:{}]", mobile, content, e.getMessage()
                    , e.getResponseBodyAsString());
        } catch (Exception e) {
            logger.error("send sms error: [mobile:{},content:{},_msg:{}]", mobile, content, e.getMessage());
        }
    }
}
