package com.ssafy.ws;

import org.springframework.stereotype.Component;

@Component
public class Action implements Movie{
	// 코드작성
	@Override
	public String getInfo() {
		return "액션영화";
	}
}

