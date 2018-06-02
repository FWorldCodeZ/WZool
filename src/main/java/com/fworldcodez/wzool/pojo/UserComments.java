package com.fworldcodez.wzool.pojo;

public class UserComments {
    private Integer id;

    private Integer zoolId;

    private Integer adId;

    private Boolean isAdmin;

    private Integer comId;

    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZoolId() {
        return zoolId;
    }

    public void setZoolId(Integer zoolId) {
        this.zoolId = zoolId;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}