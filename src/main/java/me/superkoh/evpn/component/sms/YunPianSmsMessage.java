package me.superkoh.evpn.component.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

/**
 * Created by KOH on 16/5/17.
 */
public class YunPianSmsMessage implements SmsMessage {

    public static final Logger logger = LoggerFactory.getLogger(YunPianSmsMessage.class);

    private static final String TEXT_SINGLE_SEND_URL = "https://sms.yunpian.com/v2/sms/single_send.json";

    private static final String VOICE_SEND_URL = "https://voice.yunpian.com/v2/voice/send.json";

    private String apiKey;
    private RestTemplate restTemplate;

    public YunPianSmsMessage(String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = new RestTemplate();
    }

    public YunPianSmsMessage(String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendText(String mobile, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("apikey", this.apiKey);
        query.add("mobile", mobile);
        query.add("text", content);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(query, headers);
        this.query(httpEntity, TEXT_SINGLE_SEND_URL, mobile, content);
    }

    @Override
    public void sendVoice(String mobile, String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> query = new LinkedMultiValueMap<>();
        query.add("apikey", this.apiKey);
        query.add("mobile", mobile);
        query.add("code", content);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(query, headers);
        this.query(httpEntity, VOICE_SEND_URL, mobile, content);
    }

    private void query(HttpEntity<MultiValueMap<String, String>> httpEntity, String url, String mobile, String
            content) {
        try {
            ResponseEntity<YunPianSendResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
                    httpEntity, YunPianSendResponse.class);
            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                YunPianSendResponse response = responseEntity.getBody();
                if (response.getCode() == 0) {
                    logger.info("send sms success: [mobile:{},sid:{}]", response.getMobile(), response.getSid());
                } else {
                    logger.error("send sms error: [mobile:{},msg:{}]", response.getMobile(), response.getMsg());
                }
            } else {
                logger.error("send sms error: [mobile:{},code:{},_msg:{}]", mobile, content, responseEntity
                        .getStatusCode().getReasonPhrase());
            }
        } catch (HttpClientErrorException e) {
            logger.error("send sms error: [mobile:{},code:{},_msg{},response:{}]", mobile, content, e.getMessage()
                    , e.getResponseBodyAsString());
        } catch (Exception e) {
            logger.error("send sms error: [mobile:{},code:{},_msg:{}]", mobile, content, e.getMessage());
        }
    }
}
