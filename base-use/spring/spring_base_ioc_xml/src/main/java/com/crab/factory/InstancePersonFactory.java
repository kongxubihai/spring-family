package com.crab.factory;

import com.crab.entity.Person;

/**
 * ClassName: com.crab.factory
 * Function: 实例 工厂
 * Reason: TODO
 * Date: 2020/9/16
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class InstancePersonFactory {
    public Person getPerson(String name){
        Person person = new Person();
        person.setId(2);
        person.setName(name);
        return person;
    }
}
