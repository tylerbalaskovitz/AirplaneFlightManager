package com.tbonegames.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.tbonegames.repository.FlightRepositoryImpl;
import com.tbonegames.services.FlightServiceImpl;

@Configuration
@ComponentScan("com.tbonegames")
public class AppConfig {

	@Autowired
	FlightServiceImpl fsi;
	
	@Autowired
	FlightRepositoryImpl fri;
	

	public LoggingAspect loggingAspect() {
		return new LoggingAspect();
	}
	
}
