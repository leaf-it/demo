package com.cotyledon;

import org.springframework.boot.SpringApplication;
//如果使用@SpringBootApplication需要加载此类
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@EnableEurekaClient使用
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//@EnableHystrix使用
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//@EnableHystrixDashboard使用
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//@EnableTurbine使用
//import org.springframework.cloud.netflix.turbine.EnableTurbine;



@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
