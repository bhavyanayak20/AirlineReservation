package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.aspectj.apache.bcel.ExceptionConstants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Role;
import com.example.demo.entity.Users;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ExceptionConstant;
import com.example.demo.repository.FlightRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepo;

	public FlightServiceImpl(FlightRepository flightRepo) {

		this.flightRepo = flightRepo;
	}

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Flight addFlight(FlightDto flightdto) {
		try {
			if ((flightdto.getFlightNumber().isEmpty() || flightdto.getFlightNumber().length() == 0)
					|| (flightdto.getSeatNumber().equals(null))
					|| (flightdto.getClassType().isEmpty() || flightdto.getClassType().length() == 0)
					|| (flightdto.getPrice().equals(null))) {
				throw new BusinessException("not found",ExceptionConstant.EMPTY_FIELD);
			}
			Flight flight = new Flight();
			return flightRepo.saveAndFlush(flight);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("failed to create", ExceptionConstant.ERROR_OBJECT);
		}
	}

	@Override
	public List<FlightDto> getFlight() {
		try {
		List<Flight> flightlist = flightRepo.findAll();
		if(flightlist.isEmpty())
			throw new BusinessException(ExceptionConstant.LIST_NOT_FOUND, "Failed to retrive"); 
		return flightlist.stream().map(this::convertEntityToDto).collect(Collectors.toList());
		}catch (Exception e) {
			throw new BusinessException(ExceptionConstant.LIST_IS_EMPTY, "list is empty");
		}
	}

	@Override
	public Optional<Flight> getFlightById(Integer id) {
		Optional<Flight> flt= null;
		try {
			if (id == null) {
				throw new BusinessException(ExceptionConstant.LIST_NOT_FOUND, "Failed to retrive");
			}else {
				 flt= flightRepo.findById(id);
				 if(flt == null) {
					 throw new BusinessException(ExceptionConstant.LIST_NOT_FOUND, "Failed to retrive"); 
				 }
			}
		} catch (NoSuchElementException e) {
			throw new BusinessException(ExceptionConstant.ERROR_OBJECT, "no such elemeny");
		}
		return flt;
	}

	@Override
	public Flight updateFlight(Flight flight) throws Exception {
		try {
			if (flight == null) {
				throw new BusinessException(ExceptionConstant.CANNOT_PUT_DATA, "Failed to update");
			} else {
				return flightRepo.saveAndFlush(flight);
			}
		} catch (Exception e) {
			throw new BusinessException(ExceptionConstant.ERROR_WHILE_SAVING, "Error while updating");
		}
	}

	@Override
	public void deleteFlight(Integer id) {
		try {
			flightRepo.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(ExceptionConstant.ERROR_OBJECT, "failed to delete");
		}

	}

	/*flightRepo.deleteById(id);
	 * @Override public void deleteFlight(String flightNumber) { // TODO
	 * Auto-generated method stub //flightRepo.deleteById(flightNumber);
	 * Optional<Flight> op=flightRepo.findById(flightNumber); if(op.isPresent()){
	 * flightRepo.delete(op.get()); } }
	 */

	public FlightDto convertEntityToDto(Flight flight) {
		FlightDto flightDto = new FlightDto();
		flightDto = modelMapper.map(flight, FlightDto.class);
		return flightDto;
	}

}