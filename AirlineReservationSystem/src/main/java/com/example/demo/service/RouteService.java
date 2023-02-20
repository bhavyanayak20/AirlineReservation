package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Route;

@Service
public interface RouteService {

	public String addRoute(RouteDto routeDto);

	public List<RouteDto> getRoute();

	public String updateRoute(RouteDto routeDto);

	public void deleteRoute(Integer id);

	public RouteDto getRouteById(Integer id);

	

}
