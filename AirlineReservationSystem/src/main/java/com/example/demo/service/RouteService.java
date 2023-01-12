package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Route;

@Service
public interface RouteService {

	public Route addRoute(RouteDto routedto);

	public List<RouteDto> getRoute();

	public Route updateRoute(Route route);

	public void deleteRoute(Integer id);

	public Route getRouteById(Integer id);

}
