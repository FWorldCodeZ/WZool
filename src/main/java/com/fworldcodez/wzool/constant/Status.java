package com.fworldcodez.wzool.constant;

import java.util.HashMap;
import java.util.Map;

public enum Status implements BaseEnum<Status,String> {
    DisAble("0","禁用"),Able("1","允许"),Man("1","男"),Female("0","女");

    private String value;
    private String displayName;
    static Map<String,Status> enumMap=new HashMap<>();
    static{
        for(Status type:Status.values()){
            enumMap.put(type.getValue(), type);
        }
    }
    private Status(String value,String displayName) {
        this.value=value;
        this.displayName=displayName;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String getDisplayName() {
        return displayName;
    }
    public static Status getEnum(String value) {
        return enumMap.get(value);
    }
}
