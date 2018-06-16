package com.fworldcodez.wzool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {
    @Value("${spring.redis.host}")
    public  String jedisHost;
    @Value("${spring.redis.port}")
    public  Integer jedisPort;
    @Value("${spring.redis.password}")
    public  String jedisPassword;
    @Value("${spring.redis.timeout}")
    public  int jedisTimeout;
    @Value("${spring.redis.exprie}")
    public static int jedisExprie;
    @Value("${myConfig.imagePath}")
    public  String imagePath;
    @Value("${myConfig.sessionPrefix}")
    public  String sessionPrefix;
    @Value("${myConfig.sessionInfo}")
    public  String sessionInfo;
}
