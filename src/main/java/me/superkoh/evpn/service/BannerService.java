package me.superkoh.evpn.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.superkoh.evpn.domain.mapper.evpn.BannerMapper;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.evpn.BannerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KOH on 16/5/7.
 */
@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private Jedis jedis;

    @Autowired
    private ObjectMapper objectMapper;

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public List<Banner> getBannerList() throws IOException {
        Date now = new Date();
        String strBannerList = jedis.get("banner_list");
        List<Banner> bannerList = new ArrayList<>();
        if (null != strBannerList) {
            List<Banner> tmpBannerList = objectMapper.readValue(strBannerList, new TypeReference<List<Banner>>() {
            });
            for (Banner banner : tmpBannerList) {
                if (banner.getOnlineTime().before(now) && banner.getOfflineTime().after(now)) {
                    bannerList.add(banner);
                }
            }
        } else {
            BannerExample example = new BannerExample();
            example.createCriteria().andOnlineTimeLessThan(now).andOfflineTimeGreaterThan(now);
            bannerList = bannerMapper.selectByExample(example);
            jedis.set("banner_list", objectMapper.writeValueAsString(bannerList));
            jedis.expire("banner_list", 600);
        }
        return bannerList;
    }
}
