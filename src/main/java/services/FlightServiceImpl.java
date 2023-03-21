package services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.tbonegames.flights.Flight;

@Service
public class FlightServiceImpl extends Flight implements FlightService{

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
	
	
	public void searchFlight() {
		
	}

	@Override
	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount) {

		
		
		flight.setFlightId(generateFlightID(flightId));
		
		flight.setAirlines(airlines);
		
		flight.setSource(source);
		
		flight.setDestination(destination);
		
		flight.setFare(fare);
		
		flight.setSeatCount(seatCount);
		
		flightList.add(flight);
		
	}

	
}
