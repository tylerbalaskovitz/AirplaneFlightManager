package com.tbonegames.AirlineFlightManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tbonegames.services.FlightServiceImpl;

@SpringBootApplication
public class AirlineFlightManagerApplication implements CommandLineRunner{

	@Autowired
	private FlightServiceImpl flightService;
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//ApplicationContext context = new ApplicationContext();
		context.scan("com.tbonegames");
		context.refresh();
		SpringApplication.run(AirlineFlightManagerApplication.class, args);

		
		
	}
	
	@Override
    public void run(String... args) throws Exception {
        flightService.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3);
    }

}
