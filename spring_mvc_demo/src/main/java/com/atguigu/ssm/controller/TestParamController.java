package com.atguigu.ssm.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @date 2022/12/31   23:55
 * 获取请求参数的方式：
 *  1. 通过servletAPI获取
 *      只需要在控制器方法的形参位置设置HttpServletRequest类型的参数
 *      就可以在控制器方法中使用request对象获取请求参数。
 *
 *  2. 通过控制器方法的形参获取，设置一个形参，形参的名字和请求参数的名字一直即可
 *
 *  3. @RequestParam:将请求参数和控制器方法的形参绑定
 *  @RequestParam注解的三个属性：value,required，defaultValue
 *  value：设置和形参绑定的请求参数的名字
 *  required：设置是否必须传输value所对应的参数
 *      （默认）true表示必须传输，如果不传输会报400异常
 *      false表示不是必须传输参数。没有传输，则形参值为null。
 *  defaultValue：默认值，如果没有提交参数，就会赋值默认值
 *
 *  4. @RequestHeader:将请求头信息和控制器方法的形参绑定。
 *      @RequestHeader注解的三个属性：value,required，defaultValue
 *  5. @CookieValue:将cookie数据和控制器方法的形参绑定。
 *      @CookieValue注解的三个属性：value,required，defaultValue
 *
 *  6. 通过控制器方法的实体类类型的形参获取请求参数
 *      需要在控制方法的形参位置实体类类型的形参，要保证实体类中的属性的属性名和请求参数的参数名一致
 *      可以通过实体类类型的形参获取请求参数
 *
 *  7.
 */
@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "username",required = true,defaultValue = "hello") String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println(user);
        return "success";
    }

}
