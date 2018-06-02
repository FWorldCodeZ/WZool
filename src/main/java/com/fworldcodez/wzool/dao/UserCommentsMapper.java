package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.UserComments;

public interface UserCommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserComments record);

    int insertSelective(UserComments record);

    UserComments selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserComments record);

    int updateByPrimaryKey(UserComments record);
}