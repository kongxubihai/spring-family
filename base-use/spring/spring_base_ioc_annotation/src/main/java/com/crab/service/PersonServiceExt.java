package com.crab.service;

import com.crab.dao.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: com.crab.service
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Service
public class PersonServiceExt extends PersonService {
    @Autowired
    PersonDAO personDAO;

    @Override
    public void getPerson() {
        System.out.println("PersonServiceExt.......");
        personDAO.getPerson();
    }
}
