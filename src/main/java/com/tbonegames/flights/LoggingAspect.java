package com.tbonegames.flights;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//So, the Aspect annotation goes above the class

//Aspect is the aspject J annotation while @Component means that it's being managed by Spring
@Aspect
@Component
public class LoggingAspect {
	
	
	//THis is the pointcut, by specifying when the Aspect is applied. The Advice is the @Before's body.
	@Before("execution(* com.tbonegames.repository.FlightServiceImpl.addFlight.* (..))")
	public void afterAddingFlight(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(className + "." + methodName + "() returned: ");
		
	}
	/*
	@Before("execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.print("Before method invoked::"+ joinPoint.getSignature());
	}
	*/
	
	//logs the details for whenever a new flight is booked into a log file
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//make sure you have a closing parenthesis on the right side after the quotation mark for the @Pointcut
	
	/*
	@Before("execution(* com.tbonegames.repository.FlightServiceImpl.addFlight (..))")
	public void afterAddingFlight(JoinPoint joinPoint, Object returnValue) throws Throwable{
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println(className + "." + methodName + "() returned: " + returnValue);
		
	}
	*/
	
}
