package com.fworldcodez.wzool.filter;

import java.util.LinkedHashMap;
public class FilterChainDefinitionMapStyle {
    public static LinkedHashMap<String, String> filterChainDefinitionMap() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("/page/html/pay.html", "authc");
        return linkedHashMap;
    }

}
