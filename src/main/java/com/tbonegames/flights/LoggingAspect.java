package com.tbonegames.flights;


import org.aspectj.lang.JoinPoint;
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
	public void afterAddingFlight(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(className + "." + methodName + "() returned. ");
		
	}
	
	
}
