package com.tbonegames.flights;

import java.time.LocalDate;
import java.util.Random;

public class Flight {
	Random rand = new Random();
	public Flight() {
		serialId = generateSerialId();
	}
	
	private int generateSerialId(){
		
		int id = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
		id = rand.nextInt(10000);
		while(id < 1000) {
			id = rand.nextInt(10000);
		}
		sb.append(id);
		
		}
		
		String value = sb.toString();
		id = Integer.parseInt(value);
		return id;
		
	}

	private Integer serialId;
	private String flightId;
	private String airlines;
	private String source;
	private String destination;
	private Double fare;
	private LocalDate journeyDate;
	private Integer seatCount;
	
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public LocalDate getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	public Integer getSerialId() {
		return serialId;
	}
	public void setSerialId(Integer serialId) {
		this.serialId = serialId;
	}
	
}
