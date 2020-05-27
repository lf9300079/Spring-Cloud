package com.example.springcloudconsumer.webController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author eshore
 * @Date 26/5/2020
 */
@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/login")
//    @GetMapping("/login")
    public String login() {

        System.out.println("逻辑处理。。。");

//        return restTemplate.getForEntity("http://localhost:8080/login", String.class).getBody();
        /*ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://SPRINGCLOUD-PROVIDER/login", String.class);

        int statusCodeValue = responseEntity.getStatusCodeValue();
        HttpStatus httpStatus = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
        String body = responseEntity.getBody();

        System.out.println("statusCodeValue---" + statusCodeValue);
        System.out.println("httpStatus---" + httpStatus);
        System.out.println("httpHeaders---" + httpHeaders);
        System.out.println("body---" + body);*/

//        String res = restTemplate.getForObject("http://SPRINGCLOUD-PROVIDER/login", String.class);

//        MultiValueMap mvMap = new LinkedMultiValueMap();
//
//        ResponseEntity<String> r = restTemplate.postForEntity("" , mvMap , String.class);

        //PutMapping 用于update方法
//        restTemplate.put();
//        restTemplate.delete();

        return restTemplate.getForEntity("http://SPRINGCLOUD-PROVIDER/login", String.class).getBody();

    }

    @RequestMapping("/test")
    @HystrixCommand(fallbackMethod = "defaultFallback",
            ignoreExceptions = RuntimeException.class, //设置有异常则抛出，不调用fallback,不进行服务熔断
            commandProperties = {  // 设置超过4000ms，则服务熔断，调用fallback
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
            })
    public String testHystrix() {
        String res = restTemplate.getForObject("http://SPRINGCLOUD-PROVIDER/login", String.class);
        return res;
    }

    public String defaultFallback() {
        return "hystrix -- 熔断器启动";
    }

}
