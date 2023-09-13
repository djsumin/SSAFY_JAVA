package com.ssafy.hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {

	public static void main(String[] args) {
		//테스트 코드 작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		System.out.println("******1.GeneralUser");
		GeneralUser gu = context.getBean("generalUser",GeneralUser.class);
		AdminUser au = context.getBean("adminUser", AdminUser.class);			
		gu.useApp();
		System.out.println("******2.AdminUser");
		try {
			au.useApp();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
