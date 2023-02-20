package com.example.demo.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROUTE_DATA")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ROUTE_ID")
	private Integer id;

	@Column(name = "ORIGIN")
	private String origin;

	@Column(name = "DESTINATION")
	private String destination;

	@Column(name = "FLIGHT_DATE")
	private Date flightDate;

	@Column(name = "FLIGHT_TIME")
	private Timestamp flightTime;

	// relationship with Flight
//	@OneToOne
//	@JoinColumn(name="id")
//	Flight flight;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_FLIGHT_ID")
	@JoinTable(name = "ROUTE_FLIGHT", joinColumns = @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ROUTE_ID"), inverseJoinColumns = @JoinColumn(name = "FLIGHT_ID", referencedColumnName = "FLIGHT_ID"))
	private Flight flight;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

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

//	public Flight getFlight() {
//		return flight;
//	}
//
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}

	public Route() {

	}

	public Route(String origin, String destination, Date flightDate, Timestamp flightTime, Flight flight) {
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.flightTime = flightTime;
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate
				+ ", flightTime=" + flightTime + ", flight=" + flight + "]";
	}

}
