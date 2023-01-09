package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2022/12/31   1:19
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String protal(){
        //将逻辑视图返回
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

}
