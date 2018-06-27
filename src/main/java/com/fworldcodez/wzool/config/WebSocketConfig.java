package com.fworldcodez.wzool.config;

import com.fworldcodez.wzool.handler.MyWebSocketHandler;
import com.fworldcodez.wzool.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/***
 *
 * 实现接口来配置webSocket的请求路径和拦截器*/
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
webSocketHandlerRegistry.addHandler(myWebSocketHandler(),"/ws").addInterceptors(new WebSocketInterceptor());
    }
    @Bean
    public WebSocketHandler myWebSocketHandler(){
        return new MyWebSocketHandler();
    }
}
