package com.fworldcodez.wzool;

import com.fworldcodez.wzool.pojo.Cards;
import com.fworldcodez.wzool.service.CardsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CardsServiceTest {
    @Autowired
    private CardsService cardsService;
    @Test
    public void addCards(){
        Cards cards=new Cards();
        cards.setCardDescription("火热进行中，");
        cards.setCardTitle("火热进行中");
        cards.setCardPrice(50);
        cards.setCardOrtginalPrice(60);
        cards.setZoolId(1);
        Date date=new Date(2018,8,25);
//        cards.setStartTime(date);
        cardsService.addCard(cards);
    }
}
