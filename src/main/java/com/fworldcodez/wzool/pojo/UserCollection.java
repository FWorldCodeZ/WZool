package com.fworldcodez.wzool.pojo;

public class UserCollection {
    private Integer collId;

    private Integer userId;

    private Integer otherId;

    private String collType;

    public Integer getCollId() {
        return collId;
    }

    public void setCollId(Integer collId) {
        this.collId = collId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getOtherId() {
        return otherId;
    }

    public void setOtherId(Integer otherId) {
        this.otherId = otherId;
    }

    public String getCollType() {
        return collType;
    }

    public void setCollType(String collType) {
        this.collType = collType == null ? null : collType.trim();
    }
}