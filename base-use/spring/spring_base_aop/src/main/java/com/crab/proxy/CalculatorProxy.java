package proxy;

import com.crab.inter.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * ClassName: proxy
 * Function: 帮助Calculator生成代理对象的类
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class CalculatorProxy {

    /**
     * 为传入的参数对象创建一个动态代理对象
     * 调用的是jdk的基本实现
     * @param calculator
     * @return
     */
    public static Calculator getProxy(final Calculator calculator) {
        //被代理对象的类加载器
        ClassLoader loader = calculator.getClass().getClassLoader();
        //被代理对象的接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        //方法执行器，执行被代理对象的目标方法
        InvocationHandler handler = new InvocationHandler() {
            /**
             * 执行目标方法
             * @param proxy proxy 代理对象，给jdk使用，任何时候都不要操作此对象
             * @param method method 当前将要执行的目标对象的方法
             * @param args args 这个方法调用时外界传入的参数值
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println(method.getName() + "方法开始执行，参数是： " + Arrays.asList(args));
                    result = method.invoke(calculator, args);
                    System.out.println(method.getName() + "方法执行完成，结果是： " + result);
                } catch (Exception e) {
                    {
                        System.out.println(method.getName() + "方法执行出现异常： " + e.getMessage());
                    }
                } finally {
                    System.out.println(method.getName() + "方法执行结束。。。");
                }
                return result;
            }
        };

        Object proxy = Proxy.newProxyInstance(loader, interfaces, handler);
        return (Calculator) proxy;
    }
}
