package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.management.AttributeNotFoundException;

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
import com.example.demo.entity.Flight;
import com.example.demo.entity.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
	private RouteService routeService;

	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}

	@PostMapping("/add")
	public ResponseEntity<Route> addRoute(@RequestBody RouteDto routedto) {
		Route routesaved = routeService.addRoute(routedto);
		return new ResponseEntity<Route>(routesaved, HttpStatus.CREATED);

	}

	@GetMapping("/list")
	public ResponseEntity<List<RouteDto>> getRoute() {
		List<RouteDto> routelist = routeService.getRoute();
		return new ResponseEntity<List<RouteDto>>(routelist, HttpStatus.OK);
	}

	@GetMapping("/route/{routeId}")
	public ResponseEntity<Route> getRouteById(@PathVariable("routeId") Integer id) {
		Route routelist = routeService.getRouteById(id);
		return new ResponseEntity<Route>(routelist, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Route> updateRoute(@PathVariable("id") Integer id, @RequestBody Route route) {
		Route route_details = routeService.getRouteById(id);
		try {
			routeService.updateRoute(route);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Route>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{routeId}")
	public ResponseEntity<Void> deleteRoute(@PathVariable("routeId") Integer id) {
		routeService.deleteRoute(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);

	}
}
