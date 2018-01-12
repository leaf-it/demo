package com.cotyledon.web;

import com.cotyledon.aop.DemoAop;
import com.cotyledon.config.KafkaConfig;
import com.cotyledon.vo.DemoVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/demo")
public class DemoController {
    @Autowired
    DemoVO vo;
//   @Autowired
//   KafkaConfig kafkaConfig;
//    @RequestMapping(value="/string")
//    @ApiOperation(value="测试接口", notes="测试接口详细描述")
//    @HystrixCommand(fallbackMethod = "stringHystrix")
//    @DemoAop
//    public String string(@RequestBody String flag) {
//        System.out.println("hello");
//        if("t".equals(flag)) {
//            return "hello,everything is ok!";
//        } else if("f".equals(flag)){
//            throw new RuntimeException("ha, your input parameter is wrong!");
//        } else {
//            return null;
//        }
//    }
    @RequestMapping(value="/hello")
//    @DemoAop
    public DemoVO hello() {
//        DemoVO vo = new DemoVO();
//        vo.setAuthCode("authCode");
//        vo.setAuthDesc("测试");
//        System.out.println("111111111111111111还是走原方法");
        return vo;
    }

//    public String stringHystrix(String flag){
//        return  "hi,I am sorry ,something is wrong here!please ,wait some seconds!";
//    }
//    @RequestMapping(value = "/object")
//    public String testMap(){
//
//      for(Map.Entry entry :kafkaConfig.getRedisConfig().entrySet())  {
//          System.out.println(String.format("key為%s，value為%s",entry.getKey(),entry.getValue()));
//
//      }
//      return  "ok";
//    }

}
