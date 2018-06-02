package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Zools;

public interface ZoolsMapper {
    int deleteByPrimaryKey(Integer zoolId);

    int insert(Zools record);

    int insertSelective(Zools record);

    Zools selectByPrimaryKey(Integer zoolId);

    int updateByPrimaryKeySelective(Zools record);

    int updateByPrimaryKey(Zools record);
}