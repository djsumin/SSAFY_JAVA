package com.ssafy.hw;

public class UserAspect {
	
	 public void before() {
	 	System.out.println("애플리케이션을 시작합니다.");
	 }
	
	 public void afterReturn() {
	 	System.out.println("애플리케이션을 사용합니다.");
	 }
	
	 public void afterThrow(Throwable th) {
	 	if(th instanceof ApplicationException) {
	 		((ApplicationException) th).HandleException();
	 	}
	 }
	
	 public void after() {
		 System.out.println("애플리케이션을 상태와 관련없이 종료합니다.");
	 }

}
