package com.acreath.starter.threadpool.config;

import com.acreath.starter.threadpool.endpoint.ThreadPoolEndpoint;
import com.acreath.starter.threadpool.util.ThreadPoolUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class ThreadPoolAutoConfiguration  {


    @Bean
    public ThreadPoolUtil getBean(){
        return new ThreadPoolUtil();
    }


    @Bean
    @ConditionalOnMissingBean
    public ThreadPoolEndpoint getThreadPoolEndpoint (){return  new ThreadPoolEndpoint();}

}
