package com.chaos.spring.thrift.config;

import com.chaos.spring.thrift.define.gen.Demo;
import com.chaos.spring.thrift.service.DemoService;
import com.google.gson.Gson;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zcfrank1st on 27/04/2017.
 */
@Configuration
public class ApplicationConfig {
    private final DemoService demoService;

    @Autowired
    public ApplicationConfig(DemoService demoService) {
        this.demoService = demoService;
    }

    @Bean
    Gson gson() {
        return new Gson();
    }

    @Bean
    Config config() {
        return ConfigFactory.load();
    }

    @Bean
    Demo.Processor processor() {
        return new Demo.Processor(demoService);
    }
}
