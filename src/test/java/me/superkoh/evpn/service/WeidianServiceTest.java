package me.superkoh.evpn.service;

import me.superkoh.evpn.Application;
import me.superkoh.evpn.service.entity.WeidianQuery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by KOH on 16/5/13.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class WeidianServiceTest {

    @Autowired
    private WeidianService weidianService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    //    http://api.vdian.com/api?param={"order_id":"18571688"}
//            &public={"method":"vdian.order.get",
//            "access_token":"c5be93f3f2774f01c63a9c999d625a29","version":"1.0","format":"json"}
    @Test
    public void generateWeidianUrl() throws Exception {
        String expected = "http://api.vdian.com/api?param={\"order_id\":\"18571688\"}&public={\"access_token" +
                "\":\"c5be93f3f2774f01c63a9c999d625a29\",\"method\":\"vdian.order.get\",\"format\":\"json\"," +
                "\"version\":\"1.0\"}";
        WeidianQuery query = new WeidianQuery();
        query.addParam("order_id", "18571688");
        query.addPublic("method", "vdian.order.get");
        query.addPublic("access_token", "c5be93f3f2774f01c63a9c999d625a29");
        query.addPublic("version", "1.0");
        query.addPublic("format", "json");
        Assert.assertEquals(expected, weidianService.generateWeidianUrl(query));
    }

    @Test
    public void getRemoteOrderById() throws Exception {
    }

}