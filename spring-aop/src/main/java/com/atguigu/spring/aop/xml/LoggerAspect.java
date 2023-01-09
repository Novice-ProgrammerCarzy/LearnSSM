package com.atguigu.spring.aop.xml;

import com.sun.istack.internal.NotNull;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @date 2022/12/23   3:30
 */
@Component
public class LoggerAspect {

    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对于方法的签名信息
        Signature signature = joinPoint.getSignature();
//        System.out.println(signature.toString());//返回值 + 包名.类名.方法名(参数)
//        System.out.println(signature.getDeclaringType());// 声明类型 + 全类名
//        System.out.println(signature.getDeclaringTypeName()); //全类名
//        System.out.println(signature.getName()); //方法名

        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();

        System.out.println("LoggerAspect , 方法：" + signature.getName() + ",参数：" + Arrays.toString(args));
    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对于方法的签名信息
        Signature signature = joinPoint.getSignature();

//        System.out.println("LoggerAspect , 后置通知");
        System.out.println("LoggerAspect , 方法：" + signature.getName() + ",执行完毕");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        Signature signature = joinPoint.getSignature();
//        System.out.println("LoggerAspect , 返回通知");
        System.out.println("LoggerAspect , 方法：" + signature.getName() + ", 结果:" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable e){
        Signature signature = joinPoint.getSignature();
//        System.out.println("LoggerAspect , 异常通知");
        System.out.println("LoggerAspect , 方法：" + signature.getName() + ", 异常:" + e);
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知 --> 前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知 --> 返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知 --> 异常通知");
        }finally {
            System.out.println("环绕通知 --> 后置通知");
        }
        return result;
    }
}
