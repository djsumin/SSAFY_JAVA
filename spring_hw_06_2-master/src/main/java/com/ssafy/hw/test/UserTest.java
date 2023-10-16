package com.ssafy.hw.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.hw.model.dao.UserDao;
import com.ssafy.hw.model.dto.User;

public class UserTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		UserDao user = context.getBean(UserDao.class);
		
		User user2 = new User("judy223", "2134","이수민", "judy0204@navelr.cm", 25);
		user2.setImg("222");
		
		user.insert(user2);
		
		for(User u : user.selectAll())
			System.out.println(u);
		
		
		
	}
}
