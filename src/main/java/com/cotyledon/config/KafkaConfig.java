package com.cotyledon.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
public class KafkaConfig  {
    @Bean
    @ConfigurationProperties(prefix="demo")
    public Map<String,String> getRedisConfig(){
        Map<String,String> map = new HashMap<String, String>();
        return map;
    }
}
