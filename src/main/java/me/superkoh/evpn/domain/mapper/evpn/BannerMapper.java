package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPK;
import me.superkoh.evpn.domain.model.evpn.Banner;
import me.superkoh.evpn.domain.model.evpn.BannerExample;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/7.
 */
@Component
public interface BannerMapper extends BaseMapperWithPK<Banner, BannerExample, Integer> {
}
