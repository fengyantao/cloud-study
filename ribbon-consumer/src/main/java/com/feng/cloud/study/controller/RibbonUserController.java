package com.feng.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: fengyantao
 * @date: 2019/11/7 下午2:25
 * @version: V1.0
 * @review: fengyantao/2019/11/7 下午2:25
 */
@RestController
@RequestMapping("/user")
public class RibbonUserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findMovies")
    public String findMovies() {
        //注意这里使用的eureka实例的注册名
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity("http://eureka-producer/producer/movie/test", String.class);
        String body = forEntity.getBody();
        return body;

    }

    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
