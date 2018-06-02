package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Comments;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer comId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer comId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKey(Comments record);
}