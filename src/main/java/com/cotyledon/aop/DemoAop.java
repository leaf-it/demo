package com.cotyledon.aop;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented

public @interface DemoAop {
    String level() default  "info";
    String msg() default "hello,I am an annotation for log";
}
