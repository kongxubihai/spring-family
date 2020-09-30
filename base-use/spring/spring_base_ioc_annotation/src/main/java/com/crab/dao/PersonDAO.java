package com.crab.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * ClassName: com.crab.dao
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Repository("personDao")
@Scope(value = "prototype")
public class PersonDAO {
    public void getPerson() {
        System.out.println("PersonDAO:getPerson");
    }
}
