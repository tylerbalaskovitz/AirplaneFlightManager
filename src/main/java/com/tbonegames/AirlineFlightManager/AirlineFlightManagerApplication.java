package com.tbonegames.AirlineFlightManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tbonegames.repository.FlightRepositoryImpl;
import com.tbonegames.services.FlightServiceImpl;

@SpringBootApplication
public class AirlineFlightManagerApplication{

	//@Autowired
//	private FlightServiceImpl flightService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//ApplicationContext context = new ApplicationContext();
		context.scan("com.tbonegames");
		context.refresh();
		SpringApplication.run(AirlineFlightManagerApplication.class, args);

		FlightServiceImpl fsi = context.getBean(FlightServiceImpl.class);
		fsi.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3);
		
		

	}
	/*
	@Override
    public void run(String... args) throws Exception {
        flightService.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3);
    }
	*/
}
