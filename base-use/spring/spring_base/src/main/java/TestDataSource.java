package com.crab;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * ClassName: com.crab
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/16
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class TestDataSource {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context= new ClassPathXmlApplicationContext("datasource.xml");
        DruidDataSource datasource = context.getBean("datasource", DruidDataSource.class);
        System.out.println(datasource);
        System.out.println(datasource.getConnection());
    }
}
