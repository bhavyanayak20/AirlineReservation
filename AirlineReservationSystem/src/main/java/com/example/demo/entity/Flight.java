package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "FLIGHT_DATA")
public class Flight {

	@Id
	@Column(name = "FLIGHT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "FLIGHT_NUMBER")
	private String flightNumber;

	@Column(name = "SEAT_NUMBER")
	private Integer seatNumber;

	@Column(name = "CLASS_TYPE")
	private String classType;

	@Column(name = "PRICE")
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Flight(String flightNumber, Integer seatNumber, String classType, Double price) {

		this.flightNumber = flightNumber;
		this.seatNumber = seatNumber;
		this.classType = classType;
		this.price = price;
	}

	public Flight() {

	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", seatNumber=" + seatNumber + ", classType="
				+ classType + ", price=" + price + "]";
	}

}