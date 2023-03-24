package com.tbonegames.flights;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.tbonegames.repository.FlightRepositoryImpl;

public class AppConfig {

	FlightRepositoryImpl fri;
	

	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	
}
