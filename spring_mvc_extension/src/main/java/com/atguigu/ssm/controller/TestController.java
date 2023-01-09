package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2023/1/6   15:43
 */
@Controller
public class TestController {

    @RequestMapping("/test/hello")
    public String test(){
        System.out.println(1/0);
        return "success";
    }
}
