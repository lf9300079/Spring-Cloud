package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy   //开启zuul的api网关服务功能
public class SpringcloudZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudZuulApiApplication.class, args);
	}

}
