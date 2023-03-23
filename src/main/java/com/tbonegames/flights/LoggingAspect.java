package com.tbonegames.flights;


import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	
	//logs the details for whenever a new flight is booked into a log file
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//make sure you have a closing parenthesis on the right side after the quotation mark for the @Pointcut
	@Pointcut("within(@com.tbonegames.repository.FlightRepositoryImpl *)")
	public void afterAddingFlight(Object returnValue) throws Throwable{
		logger.info("The flight information {} was propperly logged", returnValue);
	}
	
}
