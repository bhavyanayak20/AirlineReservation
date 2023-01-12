package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Route;
import com.example.demo.repository.RouteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	public RouteServiceImpl(RouteRepository routeRepository) {
		super();
		this.routeRepository = routeRepository;
	}

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Route addRoute(RouteDto routedto) {
		Route route = new Route(routedto.getOrigin(), routedto.getDestination(), routedto.getFlightDate(),
				routedto.getFlightTime(),routedto.getFlight());
		return routeRepository.save(route);
	}


	@Override
	public Route updateRoute(Route route) {
		return routeRepository.save(route);
	}

	@Override
	public void deleteRoute(Integer id) {
		routeRepository.deleteById(id);
	}

	@Override
	public List<RouteDto> getRoute() {
		List<Route> routetlist = routeRepository.findAll();
		return routetlist.stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	@Override
	public Route getRouteById(Integer id) {
		return routeRepository.findById(id).get();

	}

	public RouteDto convertEntityToDto(Route route) {
		RouteDto routeDto = new RouteDto();
		routeDto = modelMapper.map(route, RouteDto.class);
		return routeDto;
	}

	
}
