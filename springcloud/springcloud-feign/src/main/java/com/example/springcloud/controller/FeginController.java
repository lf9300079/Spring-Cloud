package com.example.springcloud.controller;

import com.example.springcloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@RestController
public class FeginController {

    @Autowired
    private LoginService loginService;

//    用户访问入口
    @RequestMapping("/login")
    public String login() {

        return loginService.login();
    }

}
