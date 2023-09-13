package com.ssafy.ws;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Audience implements Person{
	//코드작성
	
	@Override
	public void doSomething() throws CallException {
		System.out.println("영화를 봅니다.");
		//예외발생코드
		if(new Random().nextBoolean()) {
			throw new CallException();
		}
	}
}
