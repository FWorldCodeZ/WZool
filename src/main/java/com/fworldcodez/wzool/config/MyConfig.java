package com.fworldcodez.wzool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Value("${myConfig.imagePath}")
    public String imagePath;
}
