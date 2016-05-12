package me.superkoh.evpn.domain.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KOH on 16/5/12.
 */
public interface BaseMapper<R, RE> {

    int countByExample(RE example);

    int deleteByExample(RE example);

    int insert(R record);

    int insertSelective(R record);

    List<R> selectByExample(RE example);

    int updateByExampleSelective(@Param("record") R record, @Param("example") RE example);

    int updateByExample(@Param("record") R record, @Param("example") RE example);
}
