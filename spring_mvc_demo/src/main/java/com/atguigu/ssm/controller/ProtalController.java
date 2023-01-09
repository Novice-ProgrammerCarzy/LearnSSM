package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @date 2022/12/31   16:05
 */
@Controller

public class ProtalController {
    @RequestMapping("/")
    public String protal(){
        return "index";
    }
}
