package com.fworldcodez.wzool;

import com.fworldcodez.wzool.handler.MyWebSocketHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSocketTest {
    @Autowired
    MyWebSocketHandler webSocketHandler;
    @Test
    public  void  sendMsg(){
        TextMessage textMessage = new TextMessage("111");
        try {
            MyWebSocketHandler.sendMessage(textMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
