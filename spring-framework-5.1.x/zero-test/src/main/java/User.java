import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * ClassName: PACKAGE_NAME
 * Function: TODO
 * Reason: TODO
 * Date: 2020/7/13
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class User {
	private String username;
	private String address;

	@Override
	public String toString() {
		return "User{" +
				"username='" + username + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		System.out.println("默认无参构造函数");
	}

	@PostConstruct
	public void initMethod1(){
		System.out.println("PostConstruct");
	}


	public void initMethod3(){
		System.out.println("init-method");
	}


}
