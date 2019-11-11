package com.feng.cloud.study.feignApi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: fengyantao
 * @date: 2019/11/11 下午3:09
 * @version: V1.0
 * @review: fengyantao/2019/11/11 下午3:09
 */
@FeignClient(value = "feign-producer")
public interface MovieClient {

    @GetMapping("/feignPro/movie/getAllMovies")
    String getAllMovies();
}
