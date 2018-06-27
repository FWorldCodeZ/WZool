package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.Cards;

import java.util.List;

public interface CardsMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(Cards record);

    int insertSelective(Cards record);

    List<Cards>  selectCards();

    Cards selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(Cards record);

    int updateByPrimaryKey(Cards record);
}