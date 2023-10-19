package com.ssafy.di2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Programmer p = (Programmer)context.getBean("programmer");
		//""안에는 applicationconfig에서의 메소드 이름을 꺼내 쓴느 거임
		p.coding();
		
		Desktop d1 = context.getBean("desktop", Desktop.class);
		Desktop d2 = context.getBean("desktop", Desktop.class);
		
		System.out.println(d1 == d2);
		//똑같은 주입이니까 자동 싱글톤
		
		
	}

}
