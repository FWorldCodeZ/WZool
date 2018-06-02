package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Cards;

public interface CardsMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Cards record);

    int insertSelective(Cards record);

    Cards selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Cards record);

    int updateByPrimaryKey(Cards record);
}