package me.superkoh.evpn.service;

import me.superkoh.evpn.component.weidian.WeidianApi;
import me.superkoh.evpn.component.weidian.entity.OrderInfo;
import me.superkoh.evpn.component.weidian.entity.WeidianPushContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * Created by KOH on 16/5/10.
 */
@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private WeidianApi weidianApi;

    @Autowired
    private UserService userService;

    @Autowired
    private Jedis jedis;

    protected String getAccessToken() throws IOException {
        String key = "weidian_access_token";
        String accessToken = jedis.get(key);
        if (null == accessToken) {
            accessToken = weidianApi.getAccessToken().access_token;
            jedis.set(key, accessToken);
            jedis.expire(key, weidianApi.getAccessToken().expires_in - 300);
        }
        return accessToken;
    }

    // TODO: 计算时间
    private int calculateMonthToAdd(OrderInfo orderInfo) {
        return 1;
    }

    public void autoDeliver(WeidianPushContent content) throws Exception {
        if ("weidian.order.already_payment".equals(content.type)) {
            userService.updateExpireDateByMobile(content.message.buyerInfo.phone, this.calculateMonthToAdd(content
                    .message));
            weidianApi.deliver(content.message.orderId, this.getAccessToken());
        }
    }

//    public WeidianResponse<OrderInfo> getRemoteOrderById(String orderId) {
//        WeidianQuery query = new WeidianQuery();
//        query.addParam("order_id", orderId);
//        query.addPublic("method", "vdian.order.get");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(query.toQueryMap(), headers);
//        ResponseEntity<WeidianResponse<OrderInfo>> responseEntity = restTemplate.exchange(WEIDIAN_BASE_URL, HttpMethod
//                .POST, httpEntity, new ParameterizedTypeReference<WeidianResponse<OrderInfo>>(){});
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            return responseEntity.getBody();
//        }
//        return null;
//    }
}
