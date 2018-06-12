package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.pojo.Zools;

public interface ZoolsService {
    //查找所有的动物园
    JsonResult selectOfCondition(Zools zools,int userId);
}
