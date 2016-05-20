package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPKAndBlobs;
import me.superkoh.evpn.domain.model.evpn.Order;
import me.superkoh.evpn.domain.model.evpn.OrderExample;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/20.
 */
@Component
public interface OrderMapper extends BaseMapperWithPKAndBlobs<Order, OrderExample, String> {
}
