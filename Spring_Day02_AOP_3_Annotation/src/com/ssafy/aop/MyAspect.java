package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통 관심사항들을 작성할 클래스를 생성한다.
@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(public * com.ssafy.aop.*.coding())")
	public void mypt() {}
	
	
	// 실행이전
	@Before("mypt()")
	public void before() {
		System.out.println("컴퓨터를 부팅한다.");
	}

	// 실행이후 ( 예외없이)
	@AfterReturning("mypt()")
	public void afterReturning() {
		System.out.println("Git에 Push한다.");
	}

	// 예외 발생
	@AfterThrowing(value = "mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("반차를 낸다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	@After("mypt()")
	public void after() {
		System.out.println("하루를 마무리한다.");
	}

	// 이런거 하나하나를 advice라고 한다.

	////////////////////////////////////////////////////////////////////////
	// around
//	@Around("mypt()")
	public void around(ProceedingJoinPoint pjt) {

		this.before();

		try {
			pjt.proceed();
			this.afterReturning();
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}

	}

}
