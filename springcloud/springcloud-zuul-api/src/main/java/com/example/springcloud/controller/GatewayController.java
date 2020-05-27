package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@RestController
public class GatewayController {

    @RequestMapping("/api/local")
    public String hello() {
        System.out.println("在api中处理逻辑、。。。");
        int a = 10 / 0;
        return "转发到api网关的controller";
    }
}
