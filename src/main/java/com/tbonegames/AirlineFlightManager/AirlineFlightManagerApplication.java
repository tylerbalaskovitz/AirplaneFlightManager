package com.tbonegames.AirlineFlightManager;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AirlineFlightManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineFlightManagerApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.tbonegames.flights");
		context.scan("com.tbonegames.repository");
		context.scan("com.tbonegames.services");
		
		/*
		 * 	private Integer serialId;
	private String flightId;
	private String airlines;
	private String source;
	private String destination;
	private Double fare;
	private LocalDate journeyDate;
	private Integer seatCount;
		 * fields for creating a new flight 
		 */
		
		
		
	}

}
