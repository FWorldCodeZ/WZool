package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.pojo.UserCollection;

import java.util.Map;

public interface UserCollectionService {
    /**
     * 收藏或者取消收藏*/
    JsonResult  addCollection(UserCollection userCollection);
    /**
     * 获取藏品*/
    JsonResult selectCollections(Map map);
}
