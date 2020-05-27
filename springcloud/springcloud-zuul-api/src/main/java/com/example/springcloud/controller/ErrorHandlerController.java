package com.example.springcloud.controller;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@RestController //    配置全局错误页面
public class ErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Object error() {
        RequestContext request = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)request.getThrowable();

        return exception.nStatusCode + "---" + exception.getMessage();
    }
}
