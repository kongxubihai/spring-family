import com.crab.entity.Address;
import com.crab.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: PACKAGE_NAME
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/16
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class MyTest {
    public static void main(String[] args) {
        // 读取bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        /* 1、通过id获取对象*/
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        /*2、通过类型获取bean*/
        Person person2 = context.getBean(Person.class);
        System.out.println(person2);

        /*测试自定义初始化和销毁*/
        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("init-destroy.xml");
        Address address = (Address) context1.getBean("address");
        System.out.println(address);
        context1.close();
    }
}
