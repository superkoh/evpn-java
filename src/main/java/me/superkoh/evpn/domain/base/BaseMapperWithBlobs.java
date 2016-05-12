package me.superkoh.evpn.domain.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KOH on 16/5/12.
 */
public interface BaseMapperWithBlobs<R, RE> extends BaseMapper<R, RE> {

    List<R> selectByExampleWithBLOBs(RE example);

    int updateByExampleWithBLOBs(@Param("record") R record, @Param("example") RE example);
}
