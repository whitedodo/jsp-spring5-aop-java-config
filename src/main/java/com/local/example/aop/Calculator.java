/*
 * 	주제(Subject): AOP 프로그래밍(Aspect-Oriented Programming)
 *  파일명(Filename): Calculator.java
 *  생성일자(Created Date): 2020-10-04
 *  저자(Author): Dodo(rabbit.white@daum.net)
 *  설명(Description):
 * 
 * 	1. AOP 형태로 변형(@Service 어노테이션 추가)
 *  2. 원본 파일 com.local.example.service.Calculator.java 파일
 * 
 */

package com.local.example.aop;

import org.springframework.stereotype.Service;

@Service("cal")
public class Calculator {

	private long x;
	private long y;
	private long z;
	
	public Calculator() {
		this.x = 1;
		this.y = 2;
		this.z = 3;
	}
	
	public Calculator(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// 작업 원본(A 프로그래머 작성함)
	public long sum() {
		
		
		long result = x + y + z;
		System.out.println("비즈니스 로직");
		
		// long d = result / 0; //- 일부러 만든 코드(After Throws 보여줄려고)
		
		return result;
		
	}
	
}
