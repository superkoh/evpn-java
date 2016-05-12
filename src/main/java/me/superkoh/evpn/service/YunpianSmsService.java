package me.superkoh.evpn.service;

import me.superkoh.evpn.service.base.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/12.
 */
@Component
public class YunpianSmsService implements SmsService {

    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    @Override
    @Async
    public void send(String mobile, String content) {
        try {
            Thread.sleep(5000);
            logger.info("send sms success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
