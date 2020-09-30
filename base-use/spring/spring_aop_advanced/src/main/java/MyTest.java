import com.alibaba.druid.pool.DruidDataSource;
import com.mashibing.service.BookService;
import com.mashibing.service.MulService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * ClassName: PACKAGE_NAME
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/29
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class MyTest {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jdbcTemplate.xml");
/*
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
*/

//        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.checkout("zhangsan", 1);

//        测试事务传播特性
        MulService mulService = context.getBean("mulService", MulService.class);
        mulService.mulTx();
    }
}
