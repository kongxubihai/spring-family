package com.crab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: com.crab
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class TestAutowire {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("autowire.xml");
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person1"));
        System.out.println(context.getBean("person2"));

    }
}
