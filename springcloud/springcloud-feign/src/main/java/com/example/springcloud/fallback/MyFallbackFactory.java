package com.example.springcloud.fallback;

import com.example.springcloud.service.LoginService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@Component
public class MyFallbackFactory implements FallbackFactory<LoginService> {
    @Override
    public LoginService create(Throwable throwable) {
        return new LoginService() {

            @Override
            public String login() {
                return throwable.getMessage();
            }
        } ;
    }
}
