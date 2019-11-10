package com.feng.cloud.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 正确示例
     * 使用eureka实例注册名访问
     *
     * @return
     */
    @GetMapping("/findMovies")
    public String findMovies() {
        //注意这里使用的eureka实例的注册名
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity("http://eureka-producer/producer/movie/getAllMovies", String.class);
        String body = forEntity.getBody();
        return body;

    }

    /**
     * 错误示例
     * 使用ip:port形式访问
     *
     * @return
     */
    @GetMapping("/findMoviesError")
    public String findMoviesError() {
        //如果使用ip:port形式访问,则会报错 java.lang.IllegalStateException: No instances available for localhost
        ResponseEntity<String> forEntity = restTemplate
                .getForEntity("http://localhost:8802/producer/movie/getAllMovies", String.class);
        String body = forEntity.getBody();
        return body;

    }

}
