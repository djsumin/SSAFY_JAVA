package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	// 메서드 명이 빈의 id가 된다.
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}// 이거시 빈 등록

	@Bean
	public Laptop laptop() {
		return new Laptop();
	}

	@Bean
	public Programmer programmer() {
//		Programmer pr = new Programmer();
//		pr.setComputer(desktop()); //설정자 주입

		Programmer pr = new Programmer(desktop()); // 생성자 주입

		return pr;
	}

}
