package com.example.demo.dto;

import lombok.Data;

public class FlightDto {

	private String flightNumber;
	private Integer seatNumber;
	private String classType;
	private Double price;

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public FlightDto(String flightNumber, Integer seatNumber, String classType, Double price) {
		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
		this.classType = classType;
		this.price = price;
	}

	public FlightDto() {

	}

}