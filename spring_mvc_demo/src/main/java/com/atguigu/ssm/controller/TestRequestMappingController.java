package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2022/12/31   16:04
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }

    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println("id" + id);
        return "success";
    }
}
