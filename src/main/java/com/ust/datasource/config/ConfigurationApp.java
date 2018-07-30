package com.ust.datasource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ConfigurationApp {

    @Bean
    protected Random randomBean() {
        return new Random();
    }

}
