package me.superkoh.evpn.domain.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KOH on 16/5/4.
 */
public interface BaseMapperWithBLOBs<R, RE, K> extends BaseMapper<R, RE, K> {

    List<R> selectByExampleWithBLOBs(RE example);

    int updateByExampleWithBLOBs(@Param("record") R record, @Param("example") RE example);

    int updateByPrimaryKeyWithBLOBs(R record);
}
