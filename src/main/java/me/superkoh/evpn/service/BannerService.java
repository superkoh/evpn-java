package me.superkoh.evpn.service;

import me.superkoh.evpn.domain.mapper.evpn.BannerMapper;
import me.superkoh.evpn.domain.model.evpn.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by KOH on 16/5/7.
 */
@Service
public class BannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Transactional(readOnly = true, transactionManager = "eVpnTransactionManager")
    public List<Banner> getBannerList() {
        return bannerMapper.selectByExample(null);
    }
}
