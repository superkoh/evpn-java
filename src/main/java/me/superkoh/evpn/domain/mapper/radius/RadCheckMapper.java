package me.superkoh.evpn.domain.mapper.radius;

import me.superkoh.evpn.domain.base.BaseMapper;
import me.superkoh.evpn.domain.model.radius.RadCheck;
import me.superkoh.evpn.domain.model.radius.RadCheckExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface RadCheckMapper extends BaseMapper<RadCheck, RadCheckExample, Integer> {

    @Select("SELECT * FROM radcheck WHERE username=#{username} limit 1")
    RadCheck selectByUsername(String username);
}