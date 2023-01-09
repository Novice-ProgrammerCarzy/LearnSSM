package com.atguigu.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @date 2023/1/2   20:31
 * 向域对象共享数据：
 *  1. 通过ModelAndView向请求域共享数据
 *      使用ModelAndView时，可以使用其Model功能向请求域共享数据
 *      使用View功能设置逻辑视图，但是控制器方法一定要将ModelAndView作为方法的返回值
 *  2. 使用Model向请求域共享数据
 *  2. 使用Model向请求域共享数据
 *  2. 使用ModelMap向请求域共享数据
 */
@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model:向请求域中共享数据
         * View:设置逻辑视图实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域中共享数据
        mav.addObject("testRequestScope","Hello,ModelAndView");
        //设置逻辑视图
        mav.setViewName("success");
        return mav;
    }


    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","Hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","Hello,ModelMap");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","Hello,map");
        return "success";
    }


    @RequestMapping("/test/session")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","Hello,session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("testApplicationScope","Hello,application");
        return "success";
    }
}
