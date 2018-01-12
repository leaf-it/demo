package com.cotyledon.aop;

import com.cotyledon.vo.DemoVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class DemoPointCut {

    static Logger logger = LoggerFactory.getLogger(DemoPointCut.class);
    @Value("${spring.application.name}")
    private String appName;

    @Pointcut("@annotation(com.cotyledon.aop.DemoAop)")
    public void translatPointCut() {
    }

    @AfterReturning(value = "translatPointCut()", returning = "obj")
    public Object testPointCutter(JoinPoint pjp, Object obj) {

        System.out.println("------------------------------------");
        return obj;
    }
    @Before(value="translatPointCut()")
    public void beforePointCutter() {
        System.out.println("before");
        throw new  RuntimeException("1111");
    }

}
