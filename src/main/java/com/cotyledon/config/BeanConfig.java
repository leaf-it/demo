package com.cotyledon.config;

import com.cotyledon.vo.DemoVO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
public class BeanConfig {
    @Bean
    public DemoVO getInfomation(){
       DemoVO vo = new DemoVO();
       vo.setAuthDesc("test");
       vo.setAuthCode("test");
       return vo;
    }
}
