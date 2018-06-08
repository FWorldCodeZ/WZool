package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Zools;

import java.util.List;

public interface ZoolsMapper {
    int deleteByPrimaryKey(Integer zoolId);

    int insert(Zools record);

    int insertSelective(Zools record);

    Zools selectByPrimaryKey(Integer zoolId);

    int updateByPrimaryKeySelective(Zools record);

    int updateByPrimaryKey(Zools record);
    /**
     * 分页查找所有的动物园*/
    List<Zools> selectOfCondition(Zools zools);
    /**
     * 查找总数
     * */
    int selectCount(Zools zools);

}