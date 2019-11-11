package com.feng.cloud.study.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: fengyantao
 * @date: 2019/11/11 下午3:05
 * @version: V1.0
 * @review: fengyantao/2019/11/11 下午3:05
 */
@Configuration
public class FeignConfiguration {

    /**
     * 日志级别
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


}
