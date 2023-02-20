package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Flight;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>  {

}
