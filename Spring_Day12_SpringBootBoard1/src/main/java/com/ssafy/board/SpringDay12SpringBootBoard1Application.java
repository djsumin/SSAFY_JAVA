package com.ssafy.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDay12SpringBootBoard1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDay12SpringBootBoard1Application.class, args);
		for(String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
