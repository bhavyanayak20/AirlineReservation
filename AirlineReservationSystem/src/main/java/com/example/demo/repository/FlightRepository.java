package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.FlightDto;
import com.example.demo.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

}