package com.fworldcodez.wzool.common;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
    private String status = "400";

    private String msg;

    private Map<String,Object> item=new HashMap<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getItem() {
        return item;
    }

    public void setItem(Map<String, Object> item) {
        this.item = item;
    }


}
