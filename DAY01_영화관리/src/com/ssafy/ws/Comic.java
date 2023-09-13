package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Comic implements Movie {
	// 코드작성
	@Override
	public String getInfo() {
		return "코믹영화";
	}
}
