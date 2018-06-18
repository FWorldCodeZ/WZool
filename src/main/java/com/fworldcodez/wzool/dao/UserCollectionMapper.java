package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.UserCollection;

import java.util.List;
import java.util.Map;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Integer collId);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    //查找记录条数
    List<UserCollection> selectAll(UserCollection userCollection);

    //查找记录条数
    List<UserCollection> selectList(Map map);

    UserCollection selectByPrimaryKey(Integer collId);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}