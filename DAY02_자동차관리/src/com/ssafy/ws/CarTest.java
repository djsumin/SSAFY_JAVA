package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) throws GasException {
		//테스트 코드작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Person p = context.getBean("driver",Person.class);
		try {
			p.doSomething();			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
