package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPK;
import me.superkoh.evpn.domain.model.evpn.Product;
import me.superkoh.evpn.domain.model.evpn.ProductExample;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/20.
 */
@Component
public interface ProductMapper extends BaseMapperWithPK<Product, ProductExample, String> {
}
