package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class ComicBook implements Book{
	//코드작성
	@Override
	public String getInfo() {
		return "만화책";
	}
}
