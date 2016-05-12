package me.superkoh.evpn.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.Application;
import me.superkoh.evpn.configuration.RedisConfiguration;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Date;

/**
 * Created by KOH on 16/5/12.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class, RedisConfiguration.class})
@WebAppConfiguration
public class UserServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private Jedis jedis;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testJedis() throws IOException, InterruptedException {
        Date now = new Date();
        VipUser user = new VipUser();
        user.setId(1);
        user.setMobile("18621181612");
        user.setCreateTime(now);
        user.setExpireDate(now);
        jedis.set("test_user", objectMapper.writeValueAsString(user));
        jedis.expire("test_user", 5);
        VipUser expectUser = objectMapper.readValue(jedis.get("test_user"), VipUser.class);
        logger.info(expectUser.toString());
        Assert.assertEquals(1, expectUser.getId().intValue());
        Assert.assertEquals("18621181612", expectUser.getMobile());
        Assert.assertEquals(now, expectUser.getCreateTime());
        Assert.assertEquals(now, expectUser.getExpireDate());
        Thread.sleep(5000);
        String nullUser = jedis.get("test_user");
        Assert.assertNull(nullUser);
    }
}