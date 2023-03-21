package services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tbonegames.flights.Flight;
import com.tbonegames.repository.FlightRepositoryImpl;

@Service
public class FlightServiceImpl extends Flight implements FlightService{

	private FlightRepositoryImpl fri;
	
	
	//constructor of the service class that takes in the FlightRepository
	//The @Autowired annotation is used for the constructor of a class. 
	@Autowired
	public FlightServiceImpl(FlightRepositoryImpl fri) {
		this.fri = fri;
	}
	
	ArrayList <Flight> flightList = new ArrayList<>();
	Flight flight;
	
	/*Adding a flight must have the user's Details 	
	private String flightId;
	private String airlines;
	private String source;
	private String destination;
	private Double fare;
	private LocalDate journeyDate;
	private Integer seatCount;
	*/
	
	
	public void addFlight(String flightId) {
		
		
	}
	
	@Override
	@Bean
	public String generateFlightID(String flightId) {
		String currentFlight = flightId;
		if (flightId == null) {
			this.setFlightId("1001");
		} else {
			int in = 1001;
			
			for (int i = 0; i < flightList.size(); i++) {
					int tempInt	= Integer.parseInt(flightList.get(i).getFlightId());
					if (in == tempInt) {
						in++;
					}
			
			}
			StringBuilder sb = new StringBuilder();
			sb.append(in);
			
			
			
			currentFlight = sb.toString();
		}
		return currentFlight;
		

		
	}
	
	@Bean
	public void searchFlight(String flightInfo) {
		fri.search(flightInfo);
	}

	@Override
	@Bean
	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount) {

		flight = new Flight();
		
		flight.setFlightId(generateFlightID(flightId));
		
		flight.setAirlines(airlines);
		
		flight.setSource(source);
		
		flight.setDestination(destination);
		
		flight.setFare(fare);
		
		flight.setSeatCount(seatCount);
		
		fri.store(flight);
	}

	
}
