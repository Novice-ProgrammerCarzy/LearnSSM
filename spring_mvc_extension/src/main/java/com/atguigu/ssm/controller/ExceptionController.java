package com.atguigu.ssm.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @date 2023/1/6   17:06
 */
//当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {


    //设置要处理的异常信息
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView handleException(Throwable ex){
        ModelAndView modelAndView = new ModelAndView();
        //ex表示控制器方法所出现的异常
        modelAndView.addObject("ex",ex);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
