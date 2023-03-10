package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.FlightConverter;
import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.exception.AirlineConstant;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	@Autowired
	private FlightConverter flightConverter;

	@Override
	public String addFlight(FlightDto flightDto) {
		try {
			if (flightDto.getFlightNumber() == null) {
				throw new BusinessException(AirlineConstant.EMPTY_FIELD);
			} else {
				Flight flight = flightConverter.dtoToEntity(flightDto);
				flightRepo.save(flight);
				return AirlineConstant.USER_CREATED;
			}
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public List<FlightDto> getFlight() {
		try {
			List<Flight> flightlist = flightRepo.findAll();
			if (flightlist.isEmpty())
				throw new BusinessException(AirlineConstant.LIST_NOT_FOUND);
			return flightConverter.entityToDto(flightlist);
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_EMPTY_LIST);
		}
	}

	@Override
	public FlightDto getFlightById(Integer id) {
		try {
			Flight flight = flightRepo.findById(id).orElse(null);
			return flightConverter.entityToDto(flight);
		} catch (NoSuchElementException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}

	}

	/*
	 * try { Optional<Flight> flight = flightRepo.findById(id); if(flight.isEmpty())
	 * throw new BusinessException(AirlineConstant.LIST_NOT_FOUND,
	 * "Failed to retrive"); return flightConverter.entityToDto(flight);
	 * 
	 * } catch (NoSuchElementException e) { throw new
	 * BusinessException(AirlineConstant.ERROR_OBJECT, "no such elemeny"); }
	 */

	@Override
	public String updateFlight(FlightDto flightDto) throws Exception {
		try {
			if (flightDto == null) {
				throw new BusinessException(AirlineConstant.CANNOT_PUT_DATA);
			} else {
				Flight flight = flightConverter.dtoToEntity(flightDto);
				flightRepo.saveAndFlush(flight);
				return AirlineConstant.USER_CREATED;
			}
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public void deleteFlight(Integer id) {
		try {
			flightRepo.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}

	}

}

/*
 * flightRepo.deleteById(id);
 * 
 * @Override public void deleteFlight(String flightNumber) { // TODO
 * Auto-generated method stub //flightRepo.deleteById(flightNumber);
 * Optional<Flight> op=flightRepo.findById(flightNumber); if(op.isPresent()){
 * flightRepo.delete(op.get()); } }
 */

/*
 * public FlightDto convertEntityToDto(Flight flight) { FlightDto flightDto =
 * new FlightDto(); flightDto = modelMapper.map(flight, FlightDto.class); return
 * flightDto; }
 * 
 * public Flight convertEntityToDto(FlightDto flightDto) { Flight flight = new
 * Flight(); flight = modelMapper.map(flightDto, Flight.class); return flight; }
 */