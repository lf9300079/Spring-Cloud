package com.example.springcloudprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author eshore
 * @Date 26/5/2020
 */
@RestController
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "登录成功1111";
    }
}
