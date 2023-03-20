package com.tbonegames.repository;

/*
 * implements the rquired repository using the map collection
 *  Repositories are used to indicate that the class provides the mechanism for storage,
 *  retrieval, search, update and delete operation on objects
 *  
 *  I am using Generics here, it’s a powerful technology to provide loosely coupled contract for the applications to implement
 */

/*Adding a flight must have the user's details. Which can also be used when searching for information.	
private String flightId;
private String airlines;
private String source;
private String destination;
private Double fare;
private LocalDate journeyDate;
private Integer seatCount;
*/

public interface FlightRepository <T> {

	public void store(T t);

	public T retrieve(int id);

	public T search(String name);

	public T delete(int id);
}
