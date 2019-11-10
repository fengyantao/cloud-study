package com.feng.cloud.study;

import com.feng.cloud.study.annotations.MyLoadBalanced;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RibbonConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

    @Bean
    //    @LoadBalanced //开启负载均衡
    @MyLoadBalanced //开启自定义负载
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
