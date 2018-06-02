package com.fworldcodez.wzool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@MapperScan("com.fworldcodez.wzool.dao")
public class WzoolApplication {
	public static void main(String[] args) {
		SpringApplication.run(WzoolApplication.class, args);
	}
}
