package com.ssafy.di3;

public class Programmer {
	// ���α׷��Ӵ� ��ǻ�͸� ������ �־�� �ȴ�.
	private Computer computer;

	// �����ڸ� ���ؼ� �־��ְڴ�.
	// ��ü ���� ������ ���� ���̻� new �� ������ �ʰ� ������ �־���,
	public Programmer(Computer computer) {
//		computer = new Desktop();
		this.computer = computer;
	}

	// ������ (setter) ����
	// �ʵ� �̸��� set�� ���̰� ù ���ڸ� �빮�ڷ� �ٲ� ����
	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + "���� ������ �Ѵ�.");
	}

}
