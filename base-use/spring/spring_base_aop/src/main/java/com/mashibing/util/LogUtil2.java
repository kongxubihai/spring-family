package com.mashibing.util;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * ClassName: com.mashibing.util
 * Function: @Aspect 设置为切面类  没有实现接口 用cglib
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Aspect
@Component
public class LogUtil2 {
    @Before("execution( public  int  com.mashibing.inter.MyCalculator2.*(int , int))")
    public static void start(){
        System.out.println("XXX方法开始执行，使用的参数是：");
    }

    @AfterReturning("execution( public  int  com.mashibing.inter.MyCalculator2.*(int , int))")
    public static void stop(){
        System.out.println("XXX方法执行结束，结果是：");
    }

}
