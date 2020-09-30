package com.crab.service;

import com.crab.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ClassName: com.crab.service
 * Function: 泛型依赖注入
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;

    public void save(){
        System.out.println("自动注入的对象： " + baseDao);
        baseDao.save();
    }
}
