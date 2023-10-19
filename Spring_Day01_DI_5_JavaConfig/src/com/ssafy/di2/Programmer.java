package com.ssafy.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Programmer {

	private Computer computer;
	public Programmer() {
		// TODO Auto-generated constructor stub
	}

	public Programmer(Computer computer) {
		this.computer = computer;
	}

	@Autowired
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "으로 개발을 한다.");
	}
}
