package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    /**
     * 通过权限名查找id
     */
    Integer selectByName(String roleName);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}