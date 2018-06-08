package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.UserCollection;

public interface UserCollectionMapper {
    int deleteByPrimaryKey(Integer collId);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    UserCollection selectByPrimaryKey(Integer collId);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}