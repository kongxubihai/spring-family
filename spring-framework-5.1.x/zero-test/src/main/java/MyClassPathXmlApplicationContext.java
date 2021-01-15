import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zfd
 * @version v1.0
 * @description TODO
 * @date 2021/1/6 10:36
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String... configLocations){
		super(configLocations);
	}


	@Override
	protected void initPropertySources() {
		System.out.println("扩展initPropertySources");
		getEnvironment().setRequiredProperties("username");
	}
}
