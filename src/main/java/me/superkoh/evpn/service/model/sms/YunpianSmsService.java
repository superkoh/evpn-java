package me.superkoh.evpn.service.model.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

/**
 * Created by KOH on 16/5/12.
 */
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
