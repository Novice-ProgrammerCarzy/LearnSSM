package com.atguigu.ssm.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @date 2023/1/5   19:48
 *
 * Des:
 *  1. @RequestBody:将请求体中的内容和控制器方法的形参进行绑定
 *  2. 使用@RequestBody注解将json格式的请求参数转换为java对象。
 *          满足三个条件：
 *              1.导入jackson的依赖
 *              2.在SpringMVC的配置文件中设置 注解驱动开启 <mvc:annotation-driven/>
 *              3.在处理请求的控制器方法的形参位置，
 *                  直接设置json格式的请求参数要转换的java类型的形参，使用@RequestBody注解标识即可。
 *
 *  3. @ResponseBody:将所表示的控制器方法的返回值作为响应报文的响应体响应到浏览器
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody , HttpServletResponse response) throws IOException {
        System.out.println("id: " + id);
        System.out.println("requestBody: " + requestBody);
        response.getWriter().write("hello,ajax");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        response.getWriter().write("hello,RequestBody");
        System.out.println(map);
    }

    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        response.getWriter().write("hello,RequestBody");
        System.out.println(user);
    }


    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson(){
        User user = new User(1001,"admin","123456",20,"男");
        return user;
    }

}
