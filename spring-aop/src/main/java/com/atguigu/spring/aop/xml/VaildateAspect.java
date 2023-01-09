package com.atguigu.spring.aop.xml;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @date 2022/12/25   1:24
 */
@Component
public class VaildateAspect {

    public void beforeMethod(){
        System.out.println("VaildateAspect --> 前置通知");
    }
}
