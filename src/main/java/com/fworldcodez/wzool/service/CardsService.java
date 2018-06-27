package com.fworldcodez.wzool.service;

import com.fworldcodez.wzool.common.JsonResult;
import com.fworldcodez.wzool.pojo.Cards;

import java.util.List;

public interface CardsService {
    /**
     * 新增活动门票
     *
     */
    JsonResult addCard(Cards cards) ;
    /**
     * 定时查询最新活动
     * */
    List<Cards> selectCards();
}
