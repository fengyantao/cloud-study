package com.feng.cloud.study.config;

import com.feng.cloud.study.annotations.MyLoadBalanced;
import com.feng.cloud.study.interceptor.MyLoadBalancerInterceptor;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: fengyantao
 * @date: 2019/11/10 上午11:12
 * @version: V1.0
 * @review: fengyantao/2019/11/10 上午11:12
 */
@Configuration
public class MyLoadBalancerAutoConfiguration {

    @Autowired(required = false)
    @MyLoadBalanced
    private List<RestTemplate> restTemplates = Collections.emptyList();

    @Bean
    public MyLoadBalancerInterceptor myLoadBalancerInterceptor(LoadBalancerClient loadBalancer,
            LoadBalancerRequestFactory requestFactory) {
        return new MyLoadBalancerInterceptor(loadBalancer, requestFactory);
    }

    @Bean
    public SmartInitializingSingleton myLoadBalancedRestTemplateInitializer(LoadBalancerClient loadBalancer,
            LoadBalancerRequestFactory requestFactory) {
        return new SmartInitializingSingleton() {
            @Override
            public void afterSingletonsInstantiated() {
                for (RestTemplate restTemplate : MyLoadBalancerAutoConfiguration.this.restTemplates) {
                    final ArrayList<ClientHttpRequestInterceptor> list = new ArrayList<>(
                            restTemplate.getInterceptors());
                    list.add(myLoadBalancerInterceptor(loadBalancer, requestFactory));
                    restTemplate.setInterceptors(list);
                }
            }
        };
    }
}
