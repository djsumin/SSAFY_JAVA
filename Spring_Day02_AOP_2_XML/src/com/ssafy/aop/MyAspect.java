package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 관심사항들을 작성할 클래스를 생성한다.
public class MyAspect {
	// 실행이전
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}

	// 실행이후 ( 예외없이)
	public void afterReturning() {
		System.out.println("Git에 Push한다.");
	}

	// 예외 발생
	public void afterThrowing(Throwable th) {
		System.out.println("반차를 낸다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	public void after() {
		System.out.println("하루를 마무리한다.");
	}

	// 이런거 하나하나를 advice라고 한다.

	/////////////////////////////////////
	// around
	public void around(ProceedingJoinPoint pjt) {

		this.before();

		try {
			pjt.proceed();
			this.afterReturning();
		} catch (Throwable e) {
			this.afterReturning();

		} finally {
			this.after();
		}

	}

}
