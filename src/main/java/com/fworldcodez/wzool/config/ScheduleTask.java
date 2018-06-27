package com.fworldcodez.wzool.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fworldcodez.wzool.handler.MyWebSocketHandler;
import com.fworldcodez.wzool.pojo.Cards;
import com.fworldcodez.wzool.service.CardsService;
import com.fworldcodez.wzool.tools.CopyOfStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.List;

@Configuration
@Component
@EnableScheduling
public class ScheduleTask {
    Logger logger = LoggerFactory.getLogger(ScheduleTask.class);
    @Autowired
    private CardsService cardsService;

    public void messageSend() {
        List<Cards> list = cardsService.selectCards();
        JSON jsonObject = (JSON) JSONObject.toJSON(list);
        String str = jsonObject.toJSONString();
//        str = str.replace("[", "{");
//        str = str.replace("]", "}");
        logger.info(str);
        TextMessage textMessage = new TextMessage(str);
        try {
            MyWebSocketHandler.sendMessage(textMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
