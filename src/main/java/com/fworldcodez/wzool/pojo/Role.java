package com.fworldcodez.wzool.pojo;

import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;

    private String roleDescription;

    private Boolean available;

    private Integer orgunitId;

    private List<Permissions> permissionList;// 一个角色对应多个权限

    private List<User> userList;// 一个角色对应多个用户

    public List<Permissions> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permissions> permissionList) {
        this.permissionList = permissionList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }



    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Integer getOrgunitId() {
        return orgunitId;
    }

    public void setOrgunitId(Integer orgunitId) {
        this.orgunitId = orgunitId;
    }
}