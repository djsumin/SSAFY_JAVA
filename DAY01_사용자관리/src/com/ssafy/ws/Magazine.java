package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Magazine implements Book {
	//코드작성
	@Override
	public String getInfo() {
		return "잡지책";
	}
}
