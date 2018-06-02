package com.fworldcodez.wzool.dto;

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
    private String userPassWord;
    /**
     * 盐值
     * */
    private String salt;
    /**
     * 用户状态
     * */
    private Integer state;

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

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
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


}
