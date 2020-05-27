package com.example.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author eshore
 * @Date 27/5/2020
 */
@Component
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        System.out.println("在路由之前进行过滤。。。");
        return "pre";
    }

    @Override
    public int filterOrder() {
//        指定过滤器的执行顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
//        判断过滤器是否执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext cxt = RequestContext.getCurrentContext();
        HttpServletRequest request = cxt.getRequest();
        String token = request.getParameter("token");
        if(token == null) {
            cxt.setSendZuulResponse(false);
            cxt.setResponseStatusCode(401);
            cxt.addZuulResponseHeader("content-type", "text/html;charset=utf-8");
            cxt.setResponseBody("非法访问");
        }

        return null;
    }
}
