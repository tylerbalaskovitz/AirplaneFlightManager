package com.tbonegames.flights;


import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//So, the Aspect annotation goes above the class

//Aspect is the aspject J annotation while @Component means that it's being managed by Spring
@Aspect
@Component
public class LoggingAspect {
	
	private final Logger logFlightService = Logger.getLogger(LoggingAspect.class.getName());
	
	//THis is the pointcut, by specifying when the Aspect is applied. The Advice is the @Before's body.
	@Before("execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void beforeAddingFlight(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object args = joinPoint.getArgs();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("BEFORE. Flight created on " + ldt);
		System.out.println(className + "." + methodName + "() returned. " + args.toString());
		logFlightService.info(methodName + className);
	}
	
	@After("execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void afterAddingFlight(JoinPoint joinPoint) throws Throwable{
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("AFTER.  the method was executed at" + ldt);
		System.out.println(className + "." + methodName + "() returned.");
		logFlightService.info(methodName + className);
	}
	
	@AfterReturning(pointcut = "execution(* com.tbonegames.services.FlightServiceImpl.*(..))")
	public void afterReturningAddingFlight(JoinPoint joinPoint) throws Throwable{
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("==============================================");
		System.out.println("AFTER RETURNING.  the method was executed at" + ldt);
		System.out.println("AFTER RETURNING.  the method was executed at" + ldt);
		System.out.println(className + "." + methodName + "() returned.");
		logFlightService.severe(methodName);
		System.out.println("==============================================");
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.tbonegames.services.FlightServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAddingFlight(JoinPoint joinPoint) throws Throwable{
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
	
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("*******************************************");
		System.out.println("THROWING.  the method was executed at" + ldt);
		System.out.println(className + "." + methodName + "() returned.");
		logFlightService.warning(methodName);
		System.out.println("*******************************************");
	}
	
	@Around(("execution(* com.tbonegames.services.FlightServiceImpl.*(..))"))
	public void aroundAddingFlight(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		String className = proceedingJoinPoint.getTarget().getClass().getName();
		String methodName = proceedingJoinPoint.getSignature().getName();
		System.out.println("PROCEED BEFORE. The proceedingJoinPoint.proceed() is executed");
		logFlightService.severe("SEVERE in the around Advice in the PROCEED BEFORE part of code");
		logFlightService.log(Level.INFO, "SEVERE in the around Advice in the PROCEED BEFORE part of code");
		proceedingJoinPoint.proceed(); 
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("PROCEED AFTER. The proceedingJoinPoint.proceed() is executed. the method was executed at" + ldt);
		System.out.println(className + "." + methodName + "() returned.");
	}
}
