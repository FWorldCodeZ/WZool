package com.fworldcodez.wzool.service.impl;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.dao.CardsMapper;
import com.fworldcodez.wzool.pojo.Cards;
import com.fworldcodez.wzool.pojo.Zools;
import com.fworldcodez.wzool.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {
@Autowired
private CardsMapper cardsMapper;
/*
* */
    @Override
    public JsonResult addCard(Cards cards) {
        JsonResult jsonResult=new JsonResult();
        cards.setAddTime(System.currentTimeMillis());
        cardsMapper.insertSelective(cards);
        jsonResult.setMsg("添加成功!");
        jsonResult.setStatus("200");
        return jsonResult;
    }

    /**
     * 查找最新5个记录*/
    @Override
    public  List<Cards> selectCards() {
        List<Cards> list=cardsMapper.selectCards();
        return list;
    }
}
