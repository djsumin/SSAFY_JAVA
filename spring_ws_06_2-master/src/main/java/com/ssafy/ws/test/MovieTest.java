package com.ssafy.ws.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ssafy.ws.model.dao.MovieDao;
import com.ssafy.ws.model.dao.UserDao;
import com.ssafy.ws.model.dto.Movie;

public class MovieTest {
	public static void main(String[] args) {
		//코드작성
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		MovieDao movie = context.getBean(MovieDao.class);
		
		UserDao user = context.getBean(UserDao.class);
		
		for(Movie m : movie.selectAll()) {
			System.out.println(m);
		}
		
		System.out.println(user.select("ssafy"));
		
	}
}
