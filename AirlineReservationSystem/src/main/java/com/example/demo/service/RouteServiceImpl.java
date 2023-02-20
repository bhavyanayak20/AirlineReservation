package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.FlightConverter;
import com.example.demo.converter.RouteConverter;
import com.example.demo.dto.RouteDto;
import com.example.demo.entity.Flight;
import com.example.demo.entity.Route;
import com.example.demo.exception.AirlineConstant;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.RouteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Autowired
	private RouteConverter routeConverter;

	@Override
	public String addRoute(RouteDto routeDto) {
		try {
			if (routeDto.getFlight() == null) {
				throw new BusinessException(AirlineConstant.EMPTY_FIELD);
			} else {
				Route route = routeConverter.dtoToEntity(routeDto);
				routeRepository.save(route);
				return AirlineConstant.USER_CREATED;
			}
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public List<RouteDto> getRoute() {
		try {
			List<Route> routelist = routeRepository.findAll();
			if (routelist.isEmpty())
				throw new BusinessException(AirlineConstant.LIST_NOT_FOUND);
			return routeConverter.entityToDto(routelist);
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_EMPTY_LIST);
		}
	}

	@Override
	public String updateRoute(RouteDto routeDto) {
		try {
			if (routeDto == null) {
				throw new BusinessException(AirlineConstant.CANNOT_PUT_DATA);
			} else {
				Route route = routeConverter.dtoToEntity(routeDto);
				routeRepository.saveAndFlush(route);
				return AirlineConstant.USER_CREATED;
			}
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public void deleteRoute(Integer id) {
		try {
			routeRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}

	}

	@Override
	public RouteDto getRouteById(Integer id) {
		try {
			Route route = routeRepository.findById(id).orElse(null);
			return routeConverter.entityToDto(route);
		} catch (NoSuchElementException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}

	}


	
	

	

}
