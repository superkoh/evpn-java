package me.superkoh.evpn.domain.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KOH on 16/5/4.
 */
public interface BaseMapper<R, RE, K> {

    int countByExample(RE example);

    int deleteByExample(RE example);

    int deleteByPrimaryKey(K id);

    int insert(R record);

    int insertSelective(R record);

    List<R> selectByExample(RE example);

    R selectByPrimaryKey(K id);

    int updateByExampleSelective(@Param("record") R record, @Param("example") RE example);

    int updateByExample(@Param("record") R record, @Param("example") RE example);

    int updateByPrimaryKeySelective(R record);

    int updateByPrimaryKey(R record);
}
