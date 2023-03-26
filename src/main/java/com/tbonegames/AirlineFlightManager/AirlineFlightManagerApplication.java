package com.tbonegames.AirlineFlightManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tbonegames.flights.AppConfig;
import com.tbonegames.repository.FlightRepositoryImpl;
import com.tbonegames.services.FlightServiceImpl;

@SpringBootApplication
public class AirlineFlightManagerApplication{
	
	
	public static void main(String[] args) {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
			
			
			SpringApplication.run(AirlineFlightManagerApplication.class, args);

			FlightServiceImpl fsi = context.getBean(FlightServiceImpl.class);
			fsi.addFlight("1004", "American Airlines", "Chicago", "Miami", 125.00, 3, 2024, 3, 12);
			fsi.addFlight("2072", "United Airlines", "Atlanta", "Los Angeles", 255.00, 8, 2064, 12, 31);
			fsi.addFlight(null, "All Nippon Airways", "Tokyo", "Chicago", 1400.00, 1, 2030, 1, 12);
			
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
}
