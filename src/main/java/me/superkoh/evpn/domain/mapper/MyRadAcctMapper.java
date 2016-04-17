package me.superkoh.evpn.domain.mapper;

import me.superkoh.evpn.domain.entity.ServerConnectCount;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
public interface MyRadAcctMapper {

    @Select("select count(*) as cnt, nasipaddress as ip from radacct where acctstoptime is null group by ip")
    List<ServerConnectCount> selectNasConnectCount();
}
