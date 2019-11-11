package com.feng.cloud.study.controller;

import com.feng.cloud.study.feignApi.MovieClient;
import com.feng.cloud.study.feignClienImpl.MovieClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fengyantao
 * @date: 2019/11/6 下午4:26
 * @version: V1.0
 * @review: fengyantao/2019/11/6 下午4:26
 */
@RestController
@RequestMapping("/movie")
public class OpenFeignUserController implements MovieClient {

    @Autowired
    private MovieClientImpl movieClient;

    @Override
    @RequestMapping("/getAllMovies")
    public String getAllMovies() {
        return movieClient.getAllMovies();
    }
}
