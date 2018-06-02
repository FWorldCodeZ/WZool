package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.AnZools;

public interface AnZoolsMapper {
    int deleteByPrimaryKey(Integer relationId);

    int insert(AnZools record);

    int insertSelective(AnZools record);

    AnZools selectByPrimaryKey(Integer relationId);

    int updateByPrimaryKeySelective(AnZools record);

    int updateByPrimaryKey(AnZools record);
}