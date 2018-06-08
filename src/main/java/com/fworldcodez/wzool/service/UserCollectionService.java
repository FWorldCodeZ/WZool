package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;

public interface UserCollectionService {
    /**
     * 收藏或者取消收藏*/
    JsonResult addCollection();
    /**
     * 获取藏品*/
    JsonResult selectCollections();
}
