package com.tbonegames.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tbonegames.flights.Flight;
import com.tbonegames.repository.FlightRepositoryImpl;

@Qualifier("flightService")
@Service
public class FlightServiceImpl implements FlightService {

	//autowiring the reference of the FlightRepositoryImpl

	private FlightRepositoryImpl fri;
	
	
	//constructor of the service class that takes in the FlightRepository
	//The @Autowired annotation is used for the constructor of a class. 
	
	public FlightServiceImpl(@Qualifier("flightRepo") FlightRepositoryImpl fri) {
		this.fri = fri;
	}
	
	
	ArrayList <Flight> flightList = new ArrayList<>();
	Flight flight;
	
	
	@Override
	public String generateFlightID(String flightId) {
		String currentFlight = flightId;
		if (flightId == null) {
			flight.setFlightId("1001");
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
	
	public void searchFlight(String flightInfo) {
		fri.search(flightInfo);
	}

	@Override
	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount) {

		flight = new Flight();
		
		if (flightId != null) {
			flight.setFlightId(flightId);
		} else {
			flight.setFlightId("1001");
		}
		flight.setAirlines(airlines);
		
		flight.setSource(source);
		
		flight.setDestination(destination);
		
		flight.setFare(fare);
		
		flight.setSeatCount(seatCount);
		
		fri.store(flight);
	}

	
}
