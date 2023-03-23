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
		fsi.addFlight("2072", "United Airlines", "Atlanta", "Los Angeles", 255.00, 8);
		fsi.addFlight(null, "All Nippon Airways", "Tokyo", "Chicago", 1400.00, 1);
		
		FlightRepositoryImpl fri = context.getBean(FlightRepositoryImpl.class);
		System.out.println(" ");
		System.out.println("=========Adding Flights=========");
		for (int i = 0; i < fri.getRepository().size(); i++) {
			System.out.println(fri.retrieve(i).toString());
			
		}
		
		System.out.println(" ");
		System.out.println("-----------AFTER SEARCH-----------");
		System.out.println(fri.search("TOkyo").toString());
		System.out.println(fri.search("miami").toString());
		System.out.println(" ");
		
		System.out.println("-----------Record Deletion-----------");
		fri.delete(2072);
		fri.delete(1004);
		System.out.println(" ");
		System.out.println("-----------AFTER DELETION-----------");

		//since this is a map, it uses two objects as the 
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (fri.retrieve(i) != null) {
				System.out.println(fri.retrieve(i).toString());
			}
		}
		
		

	}
	/*
	@Override
    public void run(String... args) throws Exception {
        flightService.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3);
    }
	*/
}
