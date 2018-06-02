package com.fworldcodez.wzool.pojo;

import java.util.Date;

public class Comments {
    private Integer comId;

    private String comDetails;

    private Date creatTime;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComDetails() {
        return comDetails;
    }

    public void setComDetails(String comDetails) {
        this.comDetails = comDetails == null ? null : comDetails.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}