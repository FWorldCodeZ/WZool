package com.fworldcodez.wzool.pojo;

import com.sun.xml.internal.ws.developer.Serialization;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private Integer id;

    private String userName;

    private String account;

    private String userPassword;

    private String salt;

    private Integer state;

    private String address;

    private Integer phone;

    private String email;

    private Date createTime;

    private Date lastTime;

    private Integer orgunitId;

    private Set<String> roleList= new HashSet<>();// 一个用户具有多个角色

    private Set<String> perminsStrlist= new HashSet<>();// 一个角色具有多个权限

    public Set<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<String> roleList) {
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getOrgunitId() {
        return orgunitId;
    }

    public void setOrgunitId(Integer orgunitId) {
        this.orgunitId = orgunitId;
    }

    public Set<String> getPerminsStrlist() {
        return perminsStrlist;
    }

    public void setPerminsStrlist(Set<String> perminsStrlist) {
        this.perminsStrlist = perminsStrlist;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}