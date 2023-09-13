package com.ssafy.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

	// //��ĭ�� ���ġ �ʰ� �پ��� ������� �õ��� ����
	 private Car car;

	@Autowired
	 public void setCar(Car car) {
	 	this.car = car;
	 }

	 public void drive() {
	 	System.out.println(this.car.getInfo() + "�� �����մϴ�.");
	 }
}
