package com.fworldcodez.wzool.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MyWebSocketHandler implements WebSocketHandler {
    private static final Logger logger;
//    private WebSocketSession session = null;
    private static final ArrayList<WebSocketSession> sessionList;
    static {
        sessionList = new ArrayList<>();
        logger = LoggerFactory.getLogger(MyWebSocketHandler.class);
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        logger.info("成功建立连接！");
        TextMessage textMessage = new TextMessage("成功建立socket连接");
        sessionList.add(webSocketSession);
        sendMessage(textMessage);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param webSocketMessage 客户端发送过来的消息
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

    }

    /**
     * 错误消息处理
     */
    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 关闭
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        sessionList.remove(webSocketSession);
        logger.info("连接已关闭：" + closeStatus);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public static  void sendMessage(WebSocketMessage message) throws IOException {
//        this.session.getHandshakeHeaders().getAccept();
        logger.info("消息准备发送:"+sessionList.size());
        for (WebSocketSession session : sessionList) {
            try {
                logger.info("消息已发送：");
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
