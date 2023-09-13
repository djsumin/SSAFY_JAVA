package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
		//코드작성
		 ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		 Audience audience = context.getBean(Audience.class);

		 audience.watch();
	}
}
