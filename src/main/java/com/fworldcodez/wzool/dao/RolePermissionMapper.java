package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer rolePerId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer rolePerId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}