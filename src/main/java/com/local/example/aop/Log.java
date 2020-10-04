/*
 * 	주제(Subject): AOP 프로그래밍(Aspect-Oriented Programming)
 *  파일명(Filename): Log.java
 *  생성일자(Created Date): 2020-10-04
 *  저자(Author): Dodo(rabbit.white@daum.net)
 *  설명(Description):
 * 
 * 	1. 관점 작성함.
 * 
 */

package com.local.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

// 관점, 서비스
@Aspect
@Service

// 콤포넌트 사용하지 말것
public class Log {
	
	Logger logger =  LoggerFactory.getLogger(Log.class);
	
	// 섞어적어놓아도 순서를 찾아서 강제 인식함.
    
	// 2단계 - 전 단계 시야)
	@Before("execution(* com.local.example.aop.Calculator.*(..))")
	// @Before("execution(public void sum())")
	// 반환값 없어도 무방
    public void logBefore() { 
		
		logger.info("전 단계 관점 - 구현(Before)");
		
    }
    
	// 1단계 - Before보다 전 단계 실행
    // Calculator 클래스의 모든 메서드
	// 무조건 반환값이 지정되어야 함. (ProceedingJoinPoint에 대한 Object 반환값 필수 정의되어야 함)
	// @Around 이 친구만 Pjp가 있어야 함.
    @Around("execution(* com.local.example.aop.Calculator.*(..))")
    /*@Around("execution(* com.example.demo.controller..*.*(..))")*/
    /*@Around("execution(* com.example.demo..*.*(..))")*/
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable { 
    	
		logger.info("Around 단계 - 구현(Around)");
		Object result = pjp.proceed();
		return result;
		
    }
    
    // 3단계는 (중간) - 임의로 지정해줄 수 있는 것이 아님.
	// 4단계: After advice
	//@After("execution(* method1())")  -- method1 함수만 실행 
    // (이렇게 하면 안 됨. sum()을 콜하니깐)
    // @After("execution(* method1())")
    @After("execution(* sum())")
	public void afterMethod() {
    	
    	logger.info( "after Method 호출" );
    	
	}
    
    // 5단계: 맨 마지막 단계
	// after-throwing advice /// 오류가 발생할 때 호출함(무조건 보여지는 영역은 아님
    // 쉽게 비유하면, try to catch finally에서 catch 단계로 보면 됨.
    // 오류도 출력되고 after Throwing 로그 메시지도 출력된다.
    // 이 화면을 보려면, 오류나는 코드에 try to catch finally를 적용하면 안 됨.
    // 원본 비즈니스 로직 코드는 그대로 둘 것
    @AfterThrowing(
    	    pointcut = "execution(* com.local.example.aop.Calculator.sum(..))", 
    	    throwing = "ex"
    )
	public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
		
		logger.info( "after Throwing 호출" + ex.getMessage());
		
	}

    
}