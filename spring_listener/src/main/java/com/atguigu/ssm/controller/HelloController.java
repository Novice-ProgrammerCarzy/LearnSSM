package com.atguigu.ssm.controller;

import com.atguigu.ssm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @date 2023/1/6   20:54
 */
@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

}
