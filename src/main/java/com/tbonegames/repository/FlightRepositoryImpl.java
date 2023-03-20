package com.tbonegames.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tbonegames.flights.Flight;


/*
 * implements the rquired repository using the map collection
 *  Repositories are used to indicate that the class provides the mechanism for storage,
 *  retrieval, search, update and delete operation on objects
 *  
 *  
 *  
 *  
 */

@Repository
public class FlightRepositoryImpl extends Flight implements FlightRepository{

	private Map<Integer, Flight> repository;
	
	public FlightRepositoryImpl() {
		this.repository = new HashMap<>();
	}

	@Override
	public void store(Flight flight) {
		repository.put(flight.getFlightId(), flight);
	}

	@Override
	public Flight retrieve(int id) {
		
		return repository.get(id);
	}

	@Override
	public Flight search(String name) {
		//returns a collection of the values conatined in the map via the .values() method of the map collection
		Collection<Flight> flightCollection = repository.values();
		for (Flight flights: flightCollection) {
			if (flights.getDestination().equalsIgnoreCase(name)) {
				return flights;
			}
		}
		return null;
	}

	@Override
	public Object delete(int id) {
		
		return null;
	}
	
	
	
	 
	
	
}
