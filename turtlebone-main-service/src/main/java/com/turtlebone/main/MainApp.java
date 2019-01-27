package com.turtlebone.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@MapperScan("com.turtlebone.main")
@SpringBootApplication
@EnableDubboConfiguration
public class MainApp {
	public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
	}
}
