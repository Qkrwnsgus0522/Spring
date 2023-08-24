package com.spring.biz.common;

public class LogAdvice2 {

	public void printLog2() {
		System.out.println("[횡단 관심]");
		System.out.println("		비즈니스 메서드 수행 후에 호출됨");
		System.out.println();
	}
}
