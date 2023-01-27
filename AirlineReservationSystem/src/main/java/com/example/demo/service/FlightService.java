package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;

@Service

public interface FlightService {

	public String addFlight(FlightDto flightDto);

	public List<FlightDto> getFlight();

	public String updateFlight(FlightDto flightDto) throws Exception;

	public void deleteFlight(Integer id);

	public FlightDto getFlightById(Integer id);

}