package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKING_DATA")
public class Booking {
	@Id
	@Column(name = "BOOKING_ID")
	private Integer id;
	
	@Column(name = "BOOKING_DATE")
	private Date bookingDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ROUTE_ID")
	@JoinTable(name = "BOOKING_ROUTE", joinColumns = @JoinColumn(name = "BOOKING_ID", referencedColumnName = "BOOKING_ID"), inverseJoinColumns = @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ROUTE_ID"))
	private Route route;
	
	@Column(name = "BOOKING_SATUS")
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Booking(Integer id, Date bookingDate, Route route, String status) {
		super();
		this.id = id;
		this.bookingDate = bookingDate;
		this.route = route;
		this.status = status;
	}

	public Booking() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
