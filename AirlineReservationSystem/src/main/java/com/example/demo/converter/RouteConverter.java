package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.FlightDto;
import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Route;

@Component
public class RouteConverter {
	@Autowired
	private ModelMapper modelMapper;

	public RouteDto entityToDto(Route route) {
		RouteDto routeDto = new RouteDto();
		routeDto = modelMapper.map(route, RouteDto.class);
		return routeDto;
	}

	public List<RouteDto> entityToDto(List<Route> route) {
		return route.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public Route dtoToEntity(RouteDto routeDto) {
		Route route = new Route();
		route = modelMapper.map(routeDto, Route.class);
		return route;

	}

	public List<Route> dtoToEntity(List<RouteDto> routeDto) {
		return routeDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
