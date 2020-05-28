package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author eshore
 * @Date 28/5/2020
 */
@RestController
public class ConfigController {

//    第一种读取
    /*@Value("${url}")
    private String url;

    @RequestMapping("/cloud/url")
    public String url() {
        return url;
    }*/

//    第二种
    @Autowired
    private Environment env;

    @RequestMapping("/cloud/url")
    public String url() {
        return env.getProperty("url");
    }

}
