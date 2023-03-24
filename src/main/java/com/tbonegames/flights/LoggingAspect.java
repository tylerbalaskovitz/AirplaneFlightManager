package com.tbonegames.flights;


import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//So, the Aspect annotation goes above the class

//Aspect is the aspject J annotation while @Component means that it's being managed by Spring
@Aspect
@Component
public class LoggingAspect {
	
	
	//THis is the pointcut, by specifying when the Aspect is applied. The Advice is the @Before's body.
	@Before("execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void beforeAddingFlight(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object args = joinPoint.getArgs();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("BEFORE. Flight created on " + ldt);
		System.out.println(className + "." + methodName + "() returned. " + args.toString());
	}
	
	@After("execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void afterAddingFlight(JoinPoint joinPoint) throws Throwable{
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("AFTER.  the method was executed at" + ldt);
		System.out.println(className + "." + methodName + "() returned.");
	}
	
	
}
