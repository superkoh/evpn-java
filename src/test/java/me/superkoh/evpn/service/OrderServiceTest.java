package me.superkoh.evpn.service;

import me.superkoh.evpn.Application;
import me.superkoh.evpn.domain.mapper.evpn.OrderMapper;
import me.superkoh.evpn.domain.model.evpn.Order;
import me.superkoh.evpn.domain.model.evpn.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Created by KOH on 16/5/20.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@ActiveProfiles("dev")
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getProduct() throws IOException {
        Product product = orderService.getProductById("1841253131");
        Assert.assertEquals(12, product.getLimitInMonth().intValue());
    }

    @Test
    public void insertChinese() {
        orderMapper.deleteByPrimaryKey("test.123");
        Order order = new Order();
        order.setId("test.123");
        order.setDeliver(0);
        order.setStatus("abc");
        order.setTotalPrice(0);
        order.setContent("我是中文");
        orderMapper.insert(order);
        Order read = orderMapper.selectByPrimaryKey(order.getId());
        Assert.assertEquals(order.getContent(), read.getContent());
    }

}