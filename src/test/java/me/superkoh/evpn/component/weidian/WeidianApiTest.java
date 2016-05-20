package me.superkoh.evpn.component.weidian;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.Application;
import me.superkoh.evpn.component.weidian.entity.OrderInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by KOH on 16/5/18.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@ActiveProfiles("dev")
public class WeidianApiTest {

    @Autowired
    private WeidianApi weidianApi;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAccessToken() throws Exception {
//        String url = "https://api.vdian.com/token?grant_type=client_credential" +
//                "&appkey=656656&secret=4a316c8e430dc317e54062cff8a14ddc";
//        String res = restTemplate.getForObject(url, String.class);
//        System.out.println(res);

        System.out.println(weidianApi.getAccessToken().access_token);
    }

    @Test
    public void testGetOrderById() throws IOException {
        OrderInfo info = weidianApi.getOrderById("774449834117309", "1e76548a8d3960c93843abccbdcba2390004755448");
    }

    @Test
    public void deliver() throws IOException {
        weidianApi.deliver("774449834117309", "1e76548a8d3960c93843abccbdcba2390004755448");
    }

}