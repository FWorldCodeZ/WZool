package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.dao.UserCollectionMapper;
import com.fworldcodez.wzool.pojo.UserCollection;
import com.fworldcodez.wzool.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 藏品各种操作
 * @Date 2018-06-16
 *
 */
@Service
public class UserCollectionServiceImpl implements UserCollectionService {
    @Autowired
    private UserCollectionMapper userCollectionMapper;

    /**
     * 收藏或者取消藏品
     */
    @Override
    public JsonResult addCollection(UserCollection userCollection) {
        JsonResult jsonResult = new JsonResult();
        List<UserCollection> list = userCollectionMapper.selectAll(userCollection);
        int num = list.size();
        if (num == 0) {
            userCollectionMapper.insert(userCollection);
            jsonResult.setMsg("收藏成功！");
            jsonResult.setStatus("200");
            return jsonResult;
        }
        if (num == 1) {
            userCollectionMapper.deleteByPrimaryKey(list.get(0).getCollId());
            jsonResult.setMsg("取消收藏成功！");
            jsonResult.setStatus("200");
            return jsonResult;
        }
        return null;
    }
/**
 * @Description 查询藏品
 * */
    @Override
    public JsonResult selectCollections(Map map) {
        JsonResult jsonResult = new JsonResult();
        Map<String, Object> mapList = new HashMap();
        List<UserCollection> list = userCollectionMapper.selectList(map);
        mapList.put("map", list);
        jsonResult.setMsg("查询成功！");
        jsonResult.setStatus("200");
        jsonResult.setItem(mapList);
        return null;
    }
}
