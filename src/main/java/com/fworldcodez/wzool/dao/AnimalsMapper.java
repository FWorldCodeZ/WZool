package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Animals;

public interface AnimalsMapper {
    int deleteByPrimaryKey(Integer anId);

    int insert(Animals record);

    int insertSelective(Animals record);

    Animals selectByPrimaryKey(Integer anId);

    int updateByPrimaryKeySelective(Animals record);

    int updateByPrimaryKey(Animals record);
}