package com.ssafy.di2;

public class Programmer {
	// ���α׷��Ӵ� ��ǻ�͸� ������ �־�� �ȴ�.
	private Desktop computer;

	// �����ڸ� ���ؼ� �־��ְڴ�.
	// ��ü ���� ������ ���� ���̻� new �� ������ �ʰ� ������ �־���,
	public Programmer(Desktop computer) {
//		computer = new Desktop();
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "���� ������ �Ѵ�.");
	}

}
