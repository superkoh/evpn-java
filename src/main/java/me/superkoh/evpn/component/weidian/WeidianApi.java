package me.superkoh.evpn.component.weidian;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.component.weidian.entity.*;
import me.superkoh.evpn.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by KOH on 16/5/18.
 */
public class WeidianApi {

    private static final Logger logger = LoggerFactory.getLogger(WeidianApi.class);

    private String appkey;
    private String secret;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public WeidianApi(String appkey, String secret) {
        this.appkey = appkey;
        this.secret = secret;
    }

    @PostConstruct
    private void init() {
        if (null == restTemplate) {
            restTemplate = new RestTemplate();
        }
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
    }


    public WeidianTokenResult getAccessToken() throws IOException {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credential");
        params.add("appkey", this.appkey);
        params.add("secret", this.secret);
        WeidianTokenResponse response = this.getQuery("https://api.vdian.com/token", params, WeidianTokenResponse
                .class, new HashMap<>());
        return response.result;
    }

    public OrderInfo getOrderById(String orderId, String accessToken) throws IOException {
        WeidianQuery query = new WeidianQuery("vdian.order.get", accessToken);
        query.addParam("order_id", orderId);
        WeidianOrderResponse response = this.postQuery("http://api.vdian.com/api", query.toQueryMap(),
                WeidianOrderResponse.class);
        return response.result;
    }

    public void deliver(String orderId, String accessToken) throws IOException {
        WeidianQuery query = new WeidianQuery("vdian.order.deliver", accessToken);
        query.addParam("order_id", orderId);
        query.addParam("express_type", "999");
        WeidianDeliverResponse response = this.postQuery("http://api.vdian.com/api", query.toQueryMap(),
                WeidianDeliverResponse.class);
    }

    private <T> T getQuery(String baseUrl, MultiValueMap<String, String> params, Class<T> type, HashMap<String,
            String> uriVariables) throws IOException {
        try {
            UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl).queryParams(params).build();
            logger.info(uriComponents.toUriString());
            ResponseEntity<String> responseEntity = restTemplate.exchange(uriComponents.toUriString(),
                    HttpMethod.GET, null, String.class, uriVariables);
            return this.getResponse(responseEntity, type);
        } catch (HttpClientErrorException e) {
            logger.error("error: [_msg:{},response:{}]", e.getMessage(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            logger.error("error: [_msg:{}]", e.getMessage());
            throw e;
        }
    }

    private <T> T postQuery(String url, MultiValueMap<String, String> params, Class<T> type) throws IOException {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
                    String.class);
            return this.getResponse(responseEntity, type);
        } catch (BizException e) {
            throw e;
        } catch (HttpClientErrorException e) {
            logger.error("error: [_msg:{},response:{}]", e.getMessage(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            logger.error("error: [_msg:{}]", e.getMessage());
            throw e;
        }
    }

    private <T> T getResponse(ResponseEntity<String> responseEntity, Class<T> type) throws IOException {
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            logger.info(responseEntity.getBody());
            WeidianResponse response = (WeidianResponse) objectMapper.readValue(responseEntity.getBody(), type);
            if (response.status.status_code == 0) {
                return (T) response;
            } else {
                logger.error("error: [code:{},msg:{}]", response.status.status_code, response.status
                        .status_reason);
                throw new BizException(-1, response.status.status_reason);
            }
        } else {
            logger.error("error: [_msg:{}]", responseEntity.getStatusCode().getReasonPhrase());
            throw new BizException(-1, responseEntity.getStatusCode().getReasonPhrase());
        }
    }

    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
