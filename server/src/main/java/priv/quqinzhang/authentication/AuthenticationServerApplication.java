package priv.quqinzhang.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Quqin Zhang
 * @date-time 2019/12/24 23:02
 * @description spring boot 启动类
 */
@SpringBootApplication
@EnableTransactionManagement
public class AuthenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServerApplication.class, args);
	}

}
