package me.superkoh.evpn.domain.mapper.radius;

import me.superkoh.evpn.domain.base.BaseMapper;
import me.superkoh.evpn.domain.entity.NasConnectCount;
import me.superkoh.evpn.domain.model.radius.RadAcct;
import me.superkoh.evpn.domain.model.radius.RadAcctExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RadAcctMapper extends BaseMapper<RadAcct, RadAcctExample, Long> {

    @Select("select count(*) as cnt, nasipaddress as ip from radacct where acctstoptime is null group by ip")
    List<NasConnectCount> getNasConnectCount();
}