package com.mashibing.proxy;

import com.mashibing.inter.Calculator;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * ClassName: com.mashibing.CalculatorProxy
 * Function: 帮助Calculator生成代理对象的类 基于jdk
 * 限制：需要代理的目标对象实现接口 如果需要代理的目标对象没有实现任何接口，
 * 那么是无法为他创建代理对象的，这也是致命的缺陷
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class CalculatorProxy {

    /**
     * 为传入的对象创建动态代理对象
     * @param calculator
     * @return
     */
    public static Calculator getProxy(final  Calculator calculator){
        // //被代理对象的类加载器
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        // 被代理的接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        InvocationHandler h = new InvocationHandler() {
            /**
             * 执行目标方法
             * @param proxy 代理对象 给jdk用 任何时候都不要操作该对象
             * @param method    当前要执行的目标对象的方法
             * @param args  执行该方法外界传入的参数值
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;

                // 利用反射执行目标方法，然后将结果返回
                try {
                    System.out.println(method.getName()+"方法开始执行，参数是："+ Arrays.asList(args));
                    result = method.invoke(calculator, args);
                    System.out.println(method.getName()+"方法执行完成，结果是："+ result);
                } catch (IllegalAccessException e) {
                    System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
                } catch (InvocationTargetException e) {
                    System.out.println(method.getName()+"方法出现异常："+ e.getMessage());
                } finally {
                    System.out.println(method.getName()+"方法执行结束了......");
                }
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, h);
        return (Calculator) proxy;
    }
}
