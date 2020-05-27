package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //开启feign客户端支持
public class SpringcloudFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudFeignApplication.class, args);
	}

}
