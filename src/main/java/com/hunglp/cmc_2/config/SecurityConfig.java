package com.hunglp.cmc_2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev"})
public class SecurityConfig {

    @Bean
    public SecurityConfig devSecurityConfig() {
        System.out.println("Profile dev : Security Config " );
        return new SecurityConfig();
    }
}
