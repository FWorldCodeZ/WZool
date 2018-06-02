package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Permissions;

public interface PermissionsMapper {
    int deleteByPrimaryKey(Integer perId);

    int insert(Permissions record);

    int insertSelective(Permissions record);

    Permissions selectByPrimaryKey(Integer perId);

    int updateByPrimaryKeySelective(Permissions record);

    int updateByPrimaryKey(Permissions record);
}