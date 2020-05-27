package com.example.springcloud.fallback;

import com.example.springcloud.service.LoginService;
import org.springframework.stereotype.Component;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@Component
public class MyFallback implements LoginService {

//    当发生熔断时，调用该实现方法
    @Override
    public String login() {
        return "远程服务不可用，执行熔断。。。";
    }
}
