package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.BookingConverter;
import com.example.demo.dto.BookingDto;
import com.example.demo.entity.Booking;
import com.example.demo.exception.AirlineConstant;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingConverter bookingConverter;

	@Override
	public String addBooking(BookingDto bookingDto) {
		try {
			if (bookingDto.getStatus() == null) {
				throw new BusinessException(AirlineConstant.EMPTY_FIELD);
			} else {
				Booking booking = bookingConverter.dtoToEntity(bookingDto);
				bookingRepository.save(booking);
				return AirlineConstant.USER_CREATED;
			}
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public List<BookingDto> getBooking() {
		try {
			List<Booking> bookinglist = bookingRepository.findAll();
			if (bookinglist.isEmpty())
				throw new BusinessException(AirlineConstant.LIST_NOT_FOUND);
			return bookingConverter.entityToDto(bookinglist);
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_EMPTY_LIST);
		}
	}

	@Override
	public BookingDto getBookingById(Integer id) {
		try {
			Booking booking = bookingRepository.findById(id).orElse(null);
			return bookingConverter.entityToDto(booking);
		} catch (NoSuchElementException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}
	}

	@Override
	public String updateBooking(BookingDto bookingDto) {
		try {
			if (bookingDto == null) {
				throw new BusinessException(AirlineConstant.CANNOT_PUT_DATA);
			} else {
				Booking booking = bookingConverter.dtoToEntity(bookingDto);
				bookingRepository.saveAndFlush(booking);
				return AirlineConstant.USER_CREATED;
			}
		} catch (Exception e) {
			throw new BusinessException(AirlineConstant.ERROR_WHILE_SAVING);
		}
	}

	@Override
	public void deleteBooking(Integer id) {
		try {
			bookingRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(AirlineConstant.ERROR_OBJECT);
		}

	}

}
