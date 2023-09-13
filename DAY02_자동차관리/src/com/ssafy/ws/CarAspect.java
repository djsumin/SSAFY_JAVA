package com.ssafy.ws;

public class CarAspect {
	public void before() {
		// 코드작성;
		System.out.println("차를 탑니다.");
	}

	public void after_rt() {
		// 코드작성;
		System.out.println("주차를 합니다.");
	}

	// 실행 이후 (예외발생)
	public void after_th(Throwable th) {
		if (th instanceof GasException) {
			((GasException) th).handleException();
		}

	}

	public void after() {
		// 코드작성;
		System.out.println("차에서 내립니다.");
	}
}
