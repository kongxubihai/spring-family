package com.mashibing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: com.mashibing.service
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/30
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Service
public class MulService {

    @Autowired
    private BookService bookService;

    @Transactional
    public void  mulTx(){
        bookService.checkout("zhangsan", 1);
        bookService.updatePrice(1, 1000);
        int i =1 /0;
    }
}
