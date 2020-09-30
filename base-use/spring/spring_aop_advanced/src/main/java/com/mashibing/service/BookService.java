package com.mashibing.service;

import com.mashibing.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * ClassName: com.mashibing.service
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 结账：传入哪个用户买了哪本书
     * ​		isolation：设置事务的隔离级别
     * <p>
     * ​		propagation：事务的传播行为
     * <p>
     * ​		noRollbackFor：那些异常事务可以不回滚
     * <p>
     * ​		noRollbackForClassName：填写的参数是全类名
     * <p>
     * ​		rollbackFor：哪些异常事务需要回滚
     * <p>
     * ​		rollbackForClassName：填写的参数是全类名
     * <p>
     * ​		readOnly：设置事务是否为只读事务
     * <p>
     * ​		timeout：事务超出指定执行时长后自动终止并回滚,单位是秒
     *
     * @param username
     * @param id
     */

/*
    @Transactional(timeout = 3, isolation = Isolation.READ_COMMITTED,
            noRollbackFor = {ArithmeticException.class, NullPointerException.class},
            noRollbackForClassName = {"java.lang.ArithmeticException"},
            rollbackFor = {FileNotFoundException.class})
    public void checkout(String username, int id) throws FileNotFoundException {

        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username, price);
        // exception
//        int i =1/0;
        new FileInputStream("axxx.txt");
    }
*/

    /**
     * 测试事务传播特性
     * @param username
     * @param id
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void checkout(String username, int id) {
        bookDao.updateStock(id);
        int price = bookDao.getPrice(id);
        bookDao.updateBalance(username, price);
    }


    /**
     * spring的事务传播特性7种：
     * 1、REQUIRED          如果有事务在运行，当前方法就在事务中运行，否则，启动一个新事务，并在自己的事务中运行
     * 2、REQUIRES_NEW      当前方法必须启动新事务，并在自己的事务内运行，如果外部事务正在运行，应该将它挂起
     * 3、SUPPORTS          如果有事务在运行，当前的方法就在事务内运行，否则它可以不运行在事务中
     * 4、NOT_SUPPORTED     当前的方法不应该在事务内运行，如果有事务，就将它挂起
     * 5、MANDATORY         当前方法必须运行在事务内，如果没有正在运行的事务就抛出异常
     * 6、NEVER             当前的事务不应该运行在事务内，如果有正在运行的事务就抛出异常
     * 7、NESTED            如果有事务在运行，当前方法就在这个事务的嵌套事务内运行，否则，就启动一个新的事务，并在
     * 它自己的事务内运行
     *
     * @throws FileNotFoundException
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePrice(int id, int price) {
        bookDao.updatePrice(id, price);
        // exception
//        int i = 1 / 0;
    }

}
