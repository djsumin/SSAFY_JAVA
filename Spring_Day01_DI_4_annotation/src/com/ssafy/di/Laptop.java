package com.ssafy.di;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
	// �ʵ�(����) cpu, �׷���ī��, Ű����....
	public String getInfo() {
		return "��Ʈ��";
	}
}
