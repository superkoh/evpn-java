package me.superkoh.evpn.domain.base;

/**
 * Created by KOH on 16/5/4.
 */
public interface BaseMapperWithPK<R, RE, K> extends BaseMapper<R, RE> {

    int deleteByPrimaryKey(K id);

    R selectByPrimaryKey(K id);

    int updateByPrimaryKeySelective(R record);

    int updateByPrimaryKey(R record);
}
