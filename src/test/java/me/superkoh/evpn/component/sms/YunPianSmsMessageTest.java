package me.superkoh.evpn.component.sms;

import me.superkoh.evpn.Application;
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

/**
 * Created by KOH on 16/5/19.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@ActiveProfiles("dev")
public class YunPianSmsMessageTest {

    @Autowired
    private SmsMessage smsMessage;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void sendText() throws Exception {

    }

    @Test
    public void sendVoice() throws Exception {
        smsMessage.sendVoice("18621809011", "1234");
    }

}