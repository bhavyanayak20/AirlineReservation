package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;

@Component
public class BookingConverter {
	@Autowired
	private ModelMapper modelMapper;

	public BookingDto entityToDto(Booking booking) {
		BookingDto bookingDto = new BookingDto();
		bookingDto = modelMapper.map(booking, BookingDto.class);
		return bookingDto;
	}

	public List<BookingDto> entityToDto(List<Booking> booking) {
		return booking.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}

	public Booking dtoToEntity(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking = modelMapper.map(bookingDto, Booking.class);
		return booking;

	}

	public List<Booking> dtoToEntity(List<BookingDto> bookingDto) {
		return bookingDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
