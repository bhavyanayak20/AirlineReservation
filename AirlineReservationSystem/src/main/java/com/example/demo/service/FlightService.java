package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;

@Service

public interface FlightService {

	public Flight addFlight(FlightDto flightdto);

	public List<FlightDto> getFlight();

	public Flight updateFlight(Flight flight) throws Exception;

	public void deleteFlight(Integer id);

	public Optional<Flight> getFlightById(Integer id);

}