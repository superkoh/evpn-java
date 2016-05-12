package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPK;
import me.superkoh.evpn.domain.model.evpn.VipUser;
import me.superkoh.evpn.domain.model.evpn.VipUserExample;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/12.
 */
@Component
public interface VipUserMapper extends BaseMapperWithPK<VipUser, VipUserExample, Integer> {

    @Select("SELECT * FROM vip_user WHERE mobile=#{mobile} limit 1")
    @ResultMap("BaseResultMap")
    VipUser selectByMobile(String mobile);

    @Select("SELECT * FROM vip_user LEFT JOIN vip_user_token ON vip_user_token.vip_user_id = vip_user.id WHERE " +
            "vip_user_token.token=#{token} limit 1")
    @ResultMap("BaseResultMap")
    VipUser selectByUserToken(String token);

}
