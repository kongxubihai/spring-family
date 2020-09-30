import com.mashibing.inter.Calculator;
import com.mashibing.inter.MyCalculator2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        // 获取的时候需要指定接口的class  否则报：Bean named expected to be of type xxxx but was actually of type 'com.sun.proxy.$ProxyXX
        Calculator bean = context.getBean("myCalculator",Calculator.class);
        bean.add(1, 2);
        System.out.println(bean.getClass());

        /* 不实现接口  用cglib */
        MyCalculator2 myCalculator2 = context.getBean(MyCalculator2.class);
        myCalculator2.add(2, 3);
        System.out.println(myCalculator2);
        System.out.println(myCalculator2.getClass());
    }

}
