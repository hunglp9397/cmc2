package com.hunglp.cmc_2.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource("classpath:application.properties")

public class AppConfig {

    @Autowired
    Environment env;

    public void getDBConfig() {
        System.out.println(env.getProperty("spring.datasource.url"));
        System.out.println(env.getProperty("spring.datasource.username"));
        System.out.println(env.getProperty("spring.datasource.password"));
        System.out.println(env.getProperty("spring.datasource.driver-class-name"));
    }



}
