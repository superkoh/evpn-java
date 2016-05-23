package me.superkoh.evpn.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.component.weidian.WeidianApi;
import me.superkoh.evpn.component.weidian.entity.Item;
import me.superkoh.evpn.component.weidian.entity.OrderInfo;
import me.superkoh.evpn.component.weidian.entity.WeidianPushContent;
import me.superkoh.evpn.component.weidian.entity.WeidianTokenResult;
import me.superkoh.evpn.domain.mapper.evpn.OrderMapper;
import me.superkoh.evpn.domain.mapper.evpn.ProductMapper;
import me.superkoh.evpn.domain.model.evpn.Order;
import me.superkoh.evpn.domain.model.evpn.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrderMapper orderMapper;

    private String getAccessToken() throws IOException {
        String key = "weidian_access_token";
        String accessToken = jedis.get(key);
        if (null == accessToken) {
            WeidianTokenResult tokenResult = weidianApi.getAccessToken();
            accessToken = tokenResult.access_token;
            jedis.set(key, accessToken);
            jedis.expire(key, tokenResult.expires_in - 300);
        }
        return accessToken;
    }

    @Transactional(transactionManager = "eVpnTransactionManager", readOnly = true)
    public Product getProductById(String id) throws IOException {
        String key = "product_" + id;
        String productStr = jedis.get(key);
        Product product;
        if (null == productStr) {
            product = productMapper.selectByPrimaryKey(id);
            if (null != product) {
                jedis.set(key, objectMapper.writeValueAsString(product));
                jedis.expire(key, 3600 * 24);
            }
        } else {
            product = objectMapper.readValue(productStr, Product.class);
        }
        return product;
    }

    @Transactional(transactionManager = "eVpnTransactionManager", readOnly = true)
    private int calculateMonthToAdd(OrderInfo orderInfo) throws IOException {
        int month = 0;
        for (Item item : orderInfo.items) {
            Product prd = this.getProductById("weidian." + item.itemId);
            if (null != prd) {
                month += prd.getLimitInMonth() * Integer.valueOf(item.quantity);
            }
        }
        return month;
    }

    @Async
    @Transactional(transactionManager = "eVpnTransactionManager", rollbackFor = {Exception.class})
    public void orderCallback(String contentStr) throws Exception {
        WeidianPushContent content = objectMapper.readValue(contentStr, WeidianPushContent.class);
        String orderId = "weidian." + content.message.orderId;
        Order order = orderMapper.selectByPrimaryKey(orderId);
        boolean isNew = false;
        if (null == order) {
            isNew = true;
            order = new Order();
            order.setDeliver(0);
        }
        order.setId(orderId);
        order.setContent(objectMapper.writeValueAsString(content));
        order.setTotalPrice((int) (Double.parseDouble(content.message.price) * 100));
        order.setStatus(content.message.status);
        switch (content.type) {
            case "weidian.order.already_payment":
                order.setDeliver(1);
                userService.updateExpireDateByMobile(content.message.buyerInfo.phone, this.calculateMonthToAdd(content
                        .message));
                weidianApi.deliver(content.message.orderId, this.getAccessToken());
                order.setDeliver(2);
                break;
            default:
                break;
        }
        if (isNew) {
            orderMapper.insert(order);
        } else {
            orderMapper.updateByPrimaryKeyWithBLOBs(order);
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
