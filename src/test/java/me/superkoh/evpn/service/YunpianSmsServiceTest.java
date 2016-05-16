package me.superkoh.evpn.service;

import me.superkoh.evpn.Application;
import me.superkoh.evpn.service.base.SmsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by KOH on 16/5/16.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
@ActiveProfiles("dev")
public class YunpianSmsServiceTest {

    @Autowired
    @Qualifier("yunpianSmsService")
    private SmsService smsService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void send() throws Exception {
        smsService.sendLoginPassword("18621181612", "1234");
    }

}