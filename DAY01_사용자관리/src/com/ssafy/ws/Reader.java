package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Reader {
	//코드작성
	private Book book;
	
	public Reader() {
		
	}
	
	@Autowired
	public void setReader(@Qualifier("comicBook") Book book) {
		this.book = book;
	}
	
	public void read() {
		System.out.println(this.book.getInfo() + "을(를) 열심히 읽습니다.");
	}
}
