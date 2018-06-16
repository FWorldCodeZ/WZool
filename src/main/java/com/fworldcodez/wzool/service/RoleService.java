package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.pojo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 添加角色*/
    JsonResult addRole();

    /**
     * 为每个用户添加角色*/
    List<Role> matchRoleForCustomer(Integer customerId);
}
