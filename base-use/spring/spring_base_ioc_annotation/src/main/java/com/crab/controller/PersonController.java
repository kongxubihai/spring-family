package com.crab.controller;

import com.crab.dao.PersonDAO;
import com.crab.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * ClassName: com.crab.controller
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Controller
public class PersonController {


    /**
     * ​		1、@AutoWired:是spring中提供的注解，@Resource:是jdk中定义的注解，依靠的是java的标准
     * <p>
     * ​		2、@AutoWired默认是按照类型进行装配，默认情况下要求依赖的对象必须存在，@Resource默认是按照名字进行匹配的，同时可以指定name属性。
     * <p>
     * ​		3、@AutoWired只适合spring框架，而@Resource扩展性更好
     */
//    @Autowired
    @Resource
    @Qualifier("personService")
    PersonService personServiceExt;

    public PersonController() {
        System.out.println("创建对象");
    }

    public void getPerson() {
        personServiceExt.getPerson();
    }

    /**
     * * 当方法上有@AutoWired注解时：
     * *  1、此方法在bean创建的时候会自动调用
     * *  2、这个方法的每一个参数都会自动注入值
     *
     * @param personDAO
     */
    @Autowired
    public void testAutoWireOnMethod(PersonDAO personDAO) {
        System.out.println("testAutoWireOnMethod" + personDAO);
    }

    /**
     * @param personService
     * @Qualifier注解也可以作用在属性上，用来被当作id去匹配容器中的对象，如果没有 * 此注解，那么直接按照类型进行匹配
     */
    @Autowired
    public void testQualifierOnField(@Qualifier("personServiceExt") PersonService personService) {
        System.out.println("testQualifierOnField: " + personService);
    }

}
