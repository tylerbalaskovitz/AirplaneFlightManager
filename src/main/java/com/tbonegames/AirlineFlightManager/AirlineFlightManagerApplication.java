package com.tbonegames.AirlineFlightManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tbonegames.repository.FlightRepositoryImpl;
import com.tbonegames.services.FlightServiceImpl;

@SpringBootApplication
public class AirlineFlightManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineFlightManagerApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//ApplicationContext context = new ApplicationContext();
		context.scan("com.tbonegames.services");
		context.refresh();
		
		
		//you can use the AnnotationConfigAPplication context to get each of the classes as beans and then do what you need them to do.
		FlightRepositoryImpl fri = context.getBean(FlightRepositoryImpl.class);
		
		FlightServiceImpl fsi = context.getBean(FlightServiceImpl.class);
		
		fsi.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3);
		
		
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
