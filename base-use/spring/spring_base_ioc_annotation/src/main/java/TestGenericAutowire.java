import com.crab.service.StudentService;
import com.crab.service.TeacherService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: PACKAGE_NAME
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/17
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class TestGenericAutowire {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        studentService.save();

        TeacherService teacherService = context.getBean("teacherService", TeacherService.class);
        teacherService.save();
    }
}
