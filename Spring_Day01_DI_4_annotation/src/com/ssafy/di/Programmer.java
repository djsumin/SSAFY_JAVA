package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("p")
public class Programmer {
	// ���α׷��Ӵ� ��ǻ�͸� ������ �־�� �ȴ�.
//	@Autowired
//	@Qualifier("laptop")
	private Computer computer;
	
	public Programmer() {
	}
	// �����ڸ� ���ؼ� �־��ְڴ�.
	// ��ü ���� ������ ���� ���̻� new �� ������ �ʰ� ������ �־���,
	public Programmer(Computer computer) {
//		computer = new Desktop();
		this.computer = computer;
	}

	// ������ (setter) ����
	// �ʵ� �̸��� set�� ���̰� ù ���ڸ� �빮�ڷ� �ٲ� ����
	@Autowired
	public void setComputer(@Qualifier("desktop")Computer computer) {
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + "���� ������ �Ѵ�.");
	}

}
