package com.fworldcodez.wzool.dto;

import com.fworldcodez.wzool.pojo.Role;

import java.util.List;

public class UserDto {
    /**
     * 用户id
     * */
    private Integer id;
   /**
    * 用户名
    * */
    private String userName;
    /**
     * 用户账号
     * */
    private String account;
    /**
     * 用户密码
     * */
    private String userPassword;
    /**
     * 盐值
     * */
    private String salt;
    /**
     * 用户状态
     * */
    private Integer state;
    /**角色id*/

    private List<Role> roleList;// 一个用户具有多个角色

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
        this.userName = userName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }



    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
