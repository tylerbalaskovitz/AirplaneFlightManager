package com.tbonegames.repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
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
public class FlightRepositoryImpl implements FlightRepository<Object> {

	//Since this is a map, it stores two objects. The left object is the Key and the right is the value. Meaning that adding numbers to the 
	//key/value pair will kind of work?
	private Map<Integer, Flight> repository;
	
	public FlightRepositoryImpl() {
		this.repository = new HashMap<>();
		
	}
	

	@Override
	public Flight store(Flight flight) {
		//THe map function requires a key value pair, and the Integer used as the key number must be used as an Integer.
		
		repository.put(repository.size(), flight);
		Flight storedFlight = repository.get(repository.size());
		return storedFlight;
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
		for (Flight flights: flightCollection) {
			if (flights.getSource().equalsIgnoreCase(name)) {
				return flights;
			}
		}
		for (Flight flights: flightCollection) {
			try {
				LocalDate ld = LocalDate.parse(name);
				if (flights.getJourneyDate().isEqual(ld)) {
					return flights;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			}

		return null;
	}



	@Override
	public Object delete(int id) {
		for (int i = 0; i < repository.size(); i++) {
				int j = Integer.parseInt((repository.get(i).getFlightId()));
				if (id == j) {
					repository.remove(i);
					System.out.println("Flight [flightId="+id+" was deleted]");
				}
		}
		return repository.toString();
	}

	@Override
	public String toString() {
		return "FlightRepositoryImpl [repository=" + repository + "]";
	}

	public Map<Integer, Flight> getRepository() {
		return repository;
	}

	public void setRepository(Map<Integer, Flight> repository) {
		this.repository = repository;
	}
	
}
