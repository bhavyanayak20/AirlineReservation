package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Route;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
	private RouteService routeService;


	@PostMapping("/add")
	public ResponseEntity<String> addRoute(@RequestBody RouteDto routeDto) {
		String response = null;
		try {
			if (routeDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				response = routeService.addRoute(routeDto);
			}
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<RouteDto>> getRoute() {
		try {
			List<RouteDto> routelist = routeService.getRoute();
			return new ResponseEntity<List<RouteDto>>(routelist, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/route/{routeId}")
	public ResponseEntity<RouteDto> getRouteById(@PathVariable("routeId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			RouteDto route = routeService.getRouteById(id);
			return new ResponseEntity<RouteDto>(route, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRoute(@PathVariable("id") Integer id, @RequestBody RouteDto routeDto)throws Exception {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			routeService.updateRoute(routeDto);

		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{routeId}")
	public ResponseEntity<RouteDto> deleteRoute(@PathVariable("routeId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			routeService.deleteRoute(id);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
