package com.tbonegames.services;

import org.springframework.stereotype.Service;

@Service
public interface FlightService {

	
	/*
	 * Keep flight parameters adjusted at the Interface level first as a way to keep things organized neatly
	 * 
	 */
	
	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount, int year, int month, int day);
	
	public String generateFlightID(String flightId);
	
	public void searchFlight(String flightInfo);
		
	
}
