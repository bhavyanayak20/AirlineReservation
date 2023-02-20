package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;

@Service

public interface FlightService {

	public String addFlight(FlightDto flightDto);

	public List<FlightDto> getFlight();

	public String updateFlight(FlightDto flightDto) throws Exception;

	public void deleteFlight(Integer id);

	public FlightDto getFlightById(Integer id);

}