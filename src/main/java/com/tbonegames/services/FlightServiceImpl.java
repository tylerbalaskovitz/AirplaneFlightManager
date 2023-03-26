package com.tbonegames.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tbonegames.flights.Flight;
import com.tbonegames.repository.FlightRepositoryImpl;

@Qualifier("flightService")
@Service
public class FlightServiceImpl implements FlightService {
	
	Logger logger = LoggerFactory.getLogger(FlightServiceImpl.class);

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
	public void addFlight(String flightId, String airlines, String source, String destination, Double fare, Integer seatCount, int year, int month, int day) {
		
		logger.error("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXFATAL ERRORSXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
		flight = new Flight();
		
		flight.setJourneyDate(LocalDate.of(year, month, day));
		
		if (flightId != null) {
			flight.setFlightId(flightId);
		} else {
			flight.setFlightId("1001");
		}
		flight.setAirlines(airlines);
		
		flight.setSource(source);
		
		flight.setDestination(destination);
		
		flight.setFare(fare);
		
		if (checkWithinHoliday(flight.getJourneyDate())) {
	      	flight.setFare(flight.getFare()*1.2);
        	System.out.println("*NEW PRICE: "+ flight.getFare() +"*********");
		}
		
		flight.setSeatCount(seatCount);
		
		fri.store(flight);
	}
	
	//THis take the LocalDate's date to check, start date and end date, and then returns teh value of the code. This considers offsets for
	//the following years. An offset needs to be considered
	public boolean checkWithinHoliday (LocalDate dateToCheck) {
		
		boolean holidayCheck = false;
		//multiple startDateYears need to be used to consider an offset. So, a few different seasons needed to be put in to consider the offset
	
		int startDateYear = dateToCheck.getYear();
		int endDateYear = (dateToCheck.getYear()+1);
		LocalDate startDate = LocalDate.of(startDateYear, 12, 1);
		LocalDate endDate = LocalDate.of(endDateYear, 1, 31);
        if (dateToCheck.isEqual(startDate) 
    		|| dateToCheck.isEqual(endDate)
            || (dateToCheck.isAfter(startDate) && (dateToCheck.isBefore(endDate)))) {
        	holidayCheck = true;
        }
        
    	
		int lastStartDateYear = (dateToCheck.getYear()-1);
		int lastEndDateYear = (dateToCheck.getYear());
		LocalDate lastStartDate = LocalDate.of(lastStartDateYear, 12, 1);
		LocalDate lastEndDate = LocalDate.of(lastEndDateYear, 1, 31);
        if (dateToCheck.isEqual(lastStartDate) 
        		|| dateToCheck.isEqual(lastEndDate)
                || (dateToCheck.isAfter(lastStartDate) && (dateToCheck.isBefore(lastEndDate)))) {
            	holidayCheck = true;
            }
        if (holidayCheck == true) {
			System.out.println("****************************");
			System.out.println("****************************");
			System.out.println("*****HOLIDAY FLIGHT*********");
			System.out.println("*****PRICE INCREASE*********");
			System.out.println("****************************");
			System.out.println("****************************");
			System.out.println("****************************");
  
        } 
        
        return holidayCheck;
    }
		

	
}
