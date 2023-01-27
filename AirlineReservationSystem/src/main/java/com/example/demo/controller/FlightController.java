package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ControllerException;
import com.example.demo.repository.FlightRepository;
import com.example.demo.service.FlightService;

@RestController
@RequestMapping("/flight")

public class FlightController {

	@Autowired
	private FlightService flightService;

	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addFlight(@RequestBody FlightDto flightDto) {
		String response = null;
		try {
			if (flightDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				response = flightService.addFlight(flightDto);
			}
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<FlightDto>> getFlight() {
		try {
			List<FlightDto> flightlist = flightService.getFlight();
			return new ResponseEntity<List<FlightDto>>(flightlist, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
	}

	@GetMapping("/flight/{flightId}")
	public ResponseEntity<FlightDto> getFlightById(@PathVariable("flightId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			FlightDto flight = flightService.getFlightById(id);
			return new ResponseEntity<FlightDto>(flight, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@DeleteMapping("/delete/{flightId}")
	public ResponseEntity<FlightDto> deleteFlight(@PathVariable("flightId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			flightService.deleteFlight(id);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateFlight(@PathVariable("id") Integer id, @RequestBody FlightDto flightDto) throws Exception {
	//	Optional<FlightDto> flight_details = flightService.getFlightById(id);
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			flightService.updateFlight(flightDto);
			
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}