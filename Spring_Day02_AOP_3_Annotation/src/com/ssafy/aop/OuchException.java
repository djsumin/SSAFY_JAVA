package com.ssafy.aop;

import java.util.Random;

public class OuchException extends RuntimeException {
	public void handleException() {
		System.out.println("병원가자");
	}
}
