package com.fworldcodez.wzool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@EnableConfigurationProperties
@MapperScan("com.fworldcodez.wzool.dao")
public class WzoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(WzoolApplication.class, args);
	}
}
