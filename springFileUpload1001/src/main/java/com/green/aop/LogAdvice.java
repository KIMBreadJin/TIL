package com.green.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogAdvice {
	@Before("execution(* com.green.service.SampleService*.*(..))")
	public void logBefore() { //관심사(aspect/concern) 
		log.info("================?????");
	}
	@Before("execution(* com.green.service.SampleService*.doAdd(String,String,String)) && args(str1,str2,str3)")
	public void logBeforeWithParam(String str1, String str2,String str3) {
		log.info("str1:" + str1);
		log.info("str2:" + str2);
		log.info("str3:" + str3);
		//파라미터의 타입 지정  뒤쪽의  && args(...' 부분에 변수명 지정하여 Target인 doAdd의 파라미터를
		//알수 있음 
		//  str1:123  str2:345 => advice에서 출력
		// 더한 결과는 doAdd 호출후의 반환한 값 출력 
	}
//	@AfterThrowing(pointcut = "execution(* com.green.service.SampleService*.*(..))",
//			throwing = "exception")
//	public void logException(Exception exception) {
//		log.info("Exception .... !!!!" );
//		log.info("exception : " + exception);
//	}
	
	@Around("execution(* com.green.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();// 초기 시간 저장 
		
		log.info("Target: " + pjp.getTarget());
		log.info("Param: " + Arrays.toString(pjp.getArgs()));
		
		//호출 메서드 
		Object result = null;
		try {
			result = pjp.proceed(); // doAdd 함수 실행(proceed/진행)하도록 
			//명령을 주고 함수 실행 결과를 result에 저장함 
		} catch(Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis(); //doAdd 함수 호출후 종료된 시간저장
		log.info("Time:" + (end-start)); // 함수가 실행된 시간 결과 출력함 
		return result;
	}
	
	
}
