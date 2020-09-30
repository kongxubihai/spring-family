package com.crab.factoryBean;

import com.crab.entity.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * ClassName: com.crab.factoryBean
 * Function: 自定义FactoryBean
 * Reason: TODO
 * Date: 2020/9/16
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class MyFactoryBean implements FactoryBean<Person> {

    /**
     * 工厂方法，返回需要创建的对象
     * @return
     * @throws Exception
     */
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName("from myFactoryBean");
        return person;
    }

    /**
     * 返回对象的类型，spring会自动调用该方法的返回对象的类型
     * @return
     */
    public Class<?> getObjectType() {
        return Person.class;
    }

    /**
     * 是否是单例
     * @return
     */
    public boolean isSingleton() {
        return false;
    }
}
