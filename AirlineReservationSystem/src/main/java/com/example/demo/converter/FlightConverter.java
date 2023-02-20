package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;

@Component
public class FlightConverter {

	@Autowired
	private ModelMapper modelMapper;

	public FlightDto entityToDto(Flight flight) {
		FlightDto flightDto = new FlightDto();
		flightDto = modelMapper.map(flight, FlightDto.class);
		/*
		 * flightDto.setFlightNumber(flight.getFlightNumber());
		 * flightDto.setSeatNumber(flight.getSeatNumber());
		 * flightDto.setPrice(flight.getPrice());
		 * flightDto.setClassType(flight.getClassType());
		 */
		return flightDto;
	}

	public List<FlightDto> entityToDto(List<Flight> flight) {
		return flight.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public Flight dtoToEntity(FlightDto flightDto) {
		Flight flight = new Flight();
		flight = modelMapper.map(flightDto, Flight.class);

		/*
		 * flight.setFlightNumber(flightDto.getFlightNumber());
		 * flight.setSeatNumber(flightDto.getSeatNumber());
		 * flight.setPrice(flightDto.getPrice());
		 * flight.setClassType(flightDto.getClassType());
		 */
		return flight;

	}

	public List<Flight> dtoToEntity(List<FlightDto> flightDto) {
		return flightDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
