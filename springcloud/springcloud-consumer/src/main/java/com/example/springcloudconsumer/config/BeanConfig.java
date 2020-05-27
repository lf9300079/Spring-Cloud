package com.example.springcloudconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author eshore
 * @Date 26/5/2020
 */
@Configuration   //等价于spring applicationContext.xml配置文件
public class BeanConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    覆盖掉ribbon默认的负载均衡策略
    /*@Bean
    public IRule iRule() {
        return new RandomRule();
        return new Retry();  //重试策略
    }*/


}
