package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPK;
import me.superkoh.evpn.domain.model.evpn.FreeUser;
import me.superkoh.evpn.domain.model.evpn.FreeUserExample;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/11.
 */
@Component
public interface FreeUserMapper extends BaseMapperWithPK<FreeUser, FreeUserExample, Integer> {

    @Select("SELECT * FROM free_user WHERE username=#{username} limit 1")
    @ResultMap("BaseResultMap")
    FreeUser selectByUsername(String username);
}
