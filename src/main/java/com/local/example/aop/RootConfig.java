/*
 * 	주제(Subject): AOP 프로그래밍(Aspect-Oriented Programming)
 *  파일명(Filename): RootConfig.java
 *  생성일자(Created Date): 2020-10-04
 *  저자(Author): Dodo(rabbit.white@daum.net)
 *  설명(Description):
 *  1. AspectJ 환경설정
 * 
 */

package com.local.example.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.local.example.aop"})
//@ComponentScan(basePackages = {"com.local.example.beans", "com.local.example.advisor"})
@EnableAspectJAutoProxy
public class RootConfig {

}