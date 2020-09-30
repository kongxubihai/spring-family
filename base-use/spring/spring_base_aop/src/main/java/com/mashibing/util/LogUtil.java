package com.mashibing.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ClassName: com.mashibing.util
 * Function: @Aspect 设置为切面类  jdk自带的动态代理
 * @Order 注解代表优先级 越小越高
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Aspect
@Component
@Order(2)
public class LogUtil {

    /**
     * 切入点的抽取
     * 没有实现的返回void的空方法
     * 这样可以多个方法可以共用一个切点
     */
    @Pointcut("execution( public  int  com.mashibing.inter.MyCalculator.*(int , int))")
    public void  myPoint(){

    }

    /**
     *
     * @param joinPoint 切点可以获取方法名、参数等
     */
    @Before("myPoint()")
    public static void start(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println(name+ "方法开始执行，使用的参数是："+ Arrays.asList(args));
    }

    /**
     *
     * @param joinPoint 切入点可以获取方法名  方法参数
     * @param result 存放返回值
     */
    @AfterReturning(value = "execution( public  int  com.mashibing.inter.MyCalculator.*(int , int))", returning = "result")
    public static void stop(JoinPoint joinPoint, Object result){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "方法执行结束，结果是：" + result);
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param e 存放异常信息
     */
    @AfterThrowing(value = "execution(public  int  com.mashibing.inter.MyCalculator.*(int ,int ))", throwing = "e")
    public static  void logException(JoinPoint joinPoint, Exception e){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法出现异常："+ e.getMessage());
    }

    /**
     * 环绕通知是spring中功能最强大的通知
     * 环绕通知的执行顺序是优于普通通知的，具体的执行顺序如下：
     *
     * 环绕前置-->普通前置-->目标方法执行-->环绕正常结束/出现异常-->环绕后置-->普通后置-->普通返回或者异常。
     *
     * 但是需要注意的是，如果出现了异常，那么环绕通知会处理或者捕获异常，普通异常通知是接收不到的，
     * 因此最好的方式是在环绕异常通知中向外抛出异常
     * @param proceedingJoinPoint
     * @return
     */
    @Around("myPoint()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        String name = proceedingJoinPoint.getSignature().getName();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知：" + name + "方法开始，参数是：" + Arrays.asList(args));
            // 反射调用方法 就是method.invoke()
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("环绕返回通知：" + name + "方法返回，结果是：" + proceed);
        } catch (Throwable throwable) {
            System.out.println("环绕异常通知：" + name + "方法方法异常，异常信息是：" + throwable);
        }finally {
            System.out.println("环绕后置通知：" + name + "方法结束");
        }


        return proceed;
    }


}
