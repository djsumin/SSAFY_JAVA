package com.ssafy.di1;

public class Programmer {
	//���α׷��Ӵ� ��ǻ�͸� ������ �־�� �ȴ�.
	private Desktop computer;

	public Programmer() {
		computer = new Desktop();
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "���� ������ �Ѵ�.");
	}
	
	
}
