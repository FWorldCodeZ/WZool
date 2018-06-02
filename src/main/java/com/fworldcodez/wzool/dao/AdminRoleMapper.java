package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.AdminRole;

public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer adRoelId);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer adRoelId);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}