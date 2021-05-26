package com.poc.vehicleapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor(){
        final ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
        poolExecutor.setCorePoolSize(2);
        poolExecutor.setMaxPoolSize(5);
        poolExecutor.setQueueCapacity(100);
        poolExecutor.setThreadNamePrefix("CarThread-");
        poolExecutor.initialize();
        return poolExecutor;

    }
}