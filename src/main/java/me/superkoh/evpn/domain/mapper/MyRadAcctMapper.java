package me.superkoh.evpn.domain.mapper;

import me.superkoh.evpn.domain.entity.ServerConnectCount;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by KOH on 16/4/17.
 */
public interface MyRadAcctMapper {

    @Select("select count(*) as cnt, nasipaddress as ip from radacct where acctstoptime is null group by ip")
    List<ServerConnectCount> selectNasConnectCount();

    @Select("SELECT SUM(acctinputoctets+acctoutputoctets) AS usesum " +
            "FROM radacct WHERE username=#{username} " +
            "AND date_format(acctstarttime, '%Y-%m-%d') >= date_format(now(),'%Y-%m-01') " +
            "AND date_format(acctstoptime, '%Y-%m-%d') <= last_day(now())")
    Long selectMonthlyTrafficUsage(String username);
}
