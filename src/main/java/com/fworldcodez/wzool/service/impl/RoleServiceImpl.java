package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.dao.AdminRoleMapper;
import com.fworldcodez.wzool.dao.RoleMapper;
import com.fworldcodez.wzool.pojo.AdminRole;
import com.fworldcodez.wzool.pojo.Role;
import com.fworldcodez.wzool.service.RoleService;
import com.fworldcodez.wzool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Override
    public JsonResult addRole() {
        return null;
    }

    /**
     * @param customerId
     * @return List<Role>
     * 为每个用户添加角色*/
    @Override
    @Transactional
    public List<Role> matchRoleForCustomer(Integer customerId) {
        AdminRole adminRole=new AdminRole();
        Integer id=roleMapper.selectByName("普通用户");//角色id
        adminRole.setRoelId(id);
        adminRole.setAdId(customerId);
        adminRole.setOrgunitId(11111);
        adminRoleMapper.insert(adminRole);
        return null;
    }
}
