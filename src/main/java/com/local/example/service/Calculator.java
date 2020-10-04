/*
 * 	주제(Subject): 계산 프로젝트
 *  파일명(Filename): Calculator.java
 *  생성일자(Created Date): 2020-10-04
 *  저자(Author): Dodo(rabbit.white@daum.net)
 *  설명(Description):
 * 
 * 	1. 코드 작성 원본 파일(AOP 미적용)
 *  2. AOP 적용 파일: com.local.example.aop.Calculator.java
 * 
 */


package com.local.example.service;

public class Calculator {

	private long x;
	private long y;
	private long z;
	
	public Calculator(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	// 작업 원본(A 프로그래머 작성함)
	public long sum() {
		
		
		long result = x + y + z;
		
		return result;
		
	}
	
}
