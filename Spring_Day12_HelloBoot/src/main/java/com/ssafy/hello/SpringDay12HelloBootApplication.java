package com.ssafy.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay12HelloBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDay12HelloBootApplication.class, args);
		
		for(String name: context.getBeanDefinitionNames()) {
			System.out.println(name);
		} //내꺼에 등록되어있는 빈에대한 정보를 볼 수 있다.
		
	}

}
