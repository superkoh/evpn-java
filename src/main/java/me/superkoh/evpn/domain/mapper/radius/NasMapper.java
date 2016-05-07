package me.superkoh.evpn.domain.mapper.radius;

import me.superkoh.evpn.domain.base.BaseMapper;
import me.superkoh.evpn.domain.model.radius.Nas;
import me.superkoh.evpn.domain.model.radius.NasExample;
import org.springframework.stereotype.Component;

@Component
public interface NasMapper extends BaseMapper<Nas, NasExample, Integer> {
}