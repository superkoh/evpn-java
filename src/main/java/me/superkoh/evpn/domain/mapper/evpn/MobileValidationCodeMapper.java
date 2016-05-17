package me.superkoh.evpn.domain.mapper.evpn;

import me.superkoh.evpn.domain.base.BaseMapperWithPK;
import me.superkoh.evpn.domain.model.evpn.MobileValidationCode;
import me.superkoh.evpn.domain.model.evpn.MobileValidationCodeExample;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by KOH on 16/5/12.
 */
@Component
public interface MobileValidationCodeMapper extends BaseMapperWithPK<MobileValidationCode,
        MobileValidationCodeExample, Long> {

    @Select("SELECT * FROM mobile_validation_code WHERE mobile=#{mobile} ORDER BY expire_time DESC LIMIT 1")
    @ResultMap("BaseResultMap")
    MobileValidationCode getMobileCodeByMobile(String mobile);
}
