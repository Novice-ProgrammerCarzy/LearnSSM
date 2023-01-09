package com.atguigu.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 2023/1/6   15:45
 *
 * Des：
 *  拦截器的三个方法：
 *      preHandle()：在控制器方法执行之前执行，其返回值表示对控制器方法的拦截(false)或放行(true)
 *      postHandle()：在控制器方法执行之后执行
 *      afterCompletion()：渲染视图完毕之后执行。
 *
 *      多个拦截器的执行顺序和在SpringMVC配置文件的配置顺序有关
 *
 *
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor-->preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor-->postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor-->afterCompletion");
    }
}
