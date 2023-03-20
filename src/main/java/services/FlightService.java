package services;

public interface FlightService {

	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount);
	
	public String generateFlightID(String flightId);
	
	public void searchFlight();
		
	
}
