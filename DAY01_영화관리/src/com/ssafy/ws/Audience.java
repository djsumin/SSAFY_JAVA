package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Audience {
	// 코드작성
	private Movie movie;
	
	@Autowired
	@Qualifier("comic")
	public void setMovie(Movie movie) {
		this.movie=movie;
	}
	
	public void watch() {
		System.out.println(this.movie.getInfo() + "를 관람합니다.");
	}
}


