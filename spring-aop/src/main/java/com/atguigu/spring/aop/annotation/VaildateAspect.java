package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @date 2022/12/25   1:24
 */
@Component
@Aspect
@Order(2)
public class VaildateAspect {

//    @Pointcut("execution(* com.atguigu.spring.aop.annotation.*.*(..))")
//    public void pointCut(){}

    @Before("com.atguigu.spring.aop.annotation.LoggerAspect.pointCut()")
    public void beforeMethod(){
        System.out.println("VaildateAspect --> 前置通知");
    }
}
