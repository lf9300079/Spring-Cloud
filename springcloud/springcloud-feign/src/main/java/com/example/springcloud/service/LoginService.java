package com.example.springcloud.service;

import com.example.springcloud.fallback.MyFallback;
import com.example.springcloud.fallback.MyFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="springcloud-provider", fallbackFactory = MyFallbackFactory.class)
//        fallbackFactory = MyFallbackFactory.class
public interface LoginService {

//    申明远程服务提供者所提供的方法
    @RequestMapping("/login")
    public String login();
}
