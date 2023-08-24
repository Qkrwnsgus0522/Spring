package com.spring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

// aPointcut, bPointcut
@Service
@Aspect
public class LogAdvice {
	@Pointcut("execution(* com.spring.biz..*Impl.*(..))")
	public void aPointcut() {}
	@Pointcut("execution(* com.spring.biz..*Impl.select*(..))")
	public void bPointcut() {}
	
	@Before("aPointcut()")
	public void printLog() {
		System.out.println("횡단 관심: 비즈니스 메서드 수행 전에 호출됨");
	}
}
