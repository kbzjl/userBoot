package cn.ekgc.userBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b></d>
 *
 * @Author Administrator
 * @Date 2021/12/7 16:30
 * @Version 1.0
 */
@MapperScan("cn.ekgc.userBoot.dao")
@SpringBootApplication
public class UsereBootStarter {
	public static void main(String[] args) {
		SpringApplication.run(UsereBootStarter.class, args);
	}
}
