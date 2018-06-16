package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.config.MyConfig;
import com.fworldcodez.wzool.dao.ZoolsMapper;
import com.fworldcodez.wzool.pojo.Zools;
import com.fworldcodez.wzool.service.ZoolsService;
import com.fworldcodez.wzool.tools.PageTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZoolsServiceImpl implements ZoolsService {
    @Autowired
    private ZoolsMapper zoolsMapper;
    @Autowired
    private MyConfig myConfig;

    /**
     * 按条件查找所有动物园
     */
    @Transactional
    @Override
    public JsonResult selectOfCondition(Zools zools,int userId) {
        JsonResult jsonResult = new JsonResult();
        PageTools pageTools = new PageTools();

        List<Zools> list = zoolsMapper.selectOfCondition(zools);
        int count = zoolsMapper.selectCount(zools);
        pageTools.setCount(count);
        pageTools.setObj(list);
        pageTools.setPageNow(zools.getPageNow());
        pageTools.setPageNumber(zools.getPageNumber());
        Map<Object, Object> map = new HashMap<>();
        map.put("map", pageTools);
        jsonResult.setItem(map);
        jsonResult.setMsg("查询成功！");
        jsonResult.setStatus("200");

        return jsonResult;
    }
}
