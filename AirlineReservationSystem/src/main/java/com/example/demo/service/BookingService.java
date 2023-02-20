package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BookingDto;

public interface BookingService {

	public String addBooking(BookingDto bookingDto);

	public List<BookingDto> getBooking();

	public BookingDto getBookingById(Integer id);

	public String updateBooking(BookingDto bookingDto);

	public void deleteBooking(Integer id);

}
