package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.entity.weidian.OrderInfo;
import me.superkoh.evpn.domain.entity.weidian.WeidianResult;
import me.superkoh.evpn.service.entity.WeidianQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Created by KOH on 16/5/10.
 */
@Service
public class WeidianService {

    private static final String WEIDIAN_BASE_URL = "http://api.vdian.com/api";

    @Autowired
    private RestTemplate restTemplate;

    protected String generateWeidianUrl(WeidianQuery query) {
        return UriComponentsBuilder.fromHttpUrl(WEIDIAN_BASE_URL).queryParams(query.toQueryMap()).build().toUriString();
    }

    protected String getAccessToken() {
        return "";
    }

    public WeidianResult<OrderInfo> getRemoteOrderById(String orderId) {
        WeidianQuery query = new WeidianQuery();
        query.addParam("order_id", orderId);
        query.addPublic("method", "vdian.order.get");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(query.toQueryMap(), headers);
        ResponseEntity<WeidianResult<OrderInfo>> responseEntity = restTemplate.exchange(WEIDIAN_BASE_URL, HttpMethod
                .POST, httpEntity, new ParameterizedTypeReference<WeidianResult<OrderInfo>>(){});
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        return null;
    }
}
