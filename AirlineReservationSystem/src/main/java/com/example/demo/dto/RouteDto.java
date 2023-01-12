package com.example.demo.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.entity.Flight;

public class RouteDto {

	private String origin;

	private String destination;

	private Date flightDate;

	private Timestamp flightTime;

	private Flight flight;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public Timestamp getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Timestamp flightTime) {
		this.flightTime = flightTime;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	
}
