package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDto;
import com.example.demo.exception.BusinessException;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addBooking(@RequestBody BookingDto bookingDto) {
		String response = null;
		try {
			if (bookingDto == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				response = bookingService.addBooking(bookingDto);
			}
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<BookingDto>> getBooking() {
		try {
			List<BookingDto> bookinglist = bookingService.getBooking();
			return new ResponseEntity<List<BookingDto>>(bookinglist, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/booking/{bookingId}")
	public ResponseEntity<BookingDto> getBookingById(@PathVariable("bookingId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			BookingDto booking = bookingService.getBookingById(id);
			return new ResponseEntity<BookingDto>(booking, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBooking(@PathVariable("id") Integer id, @RequestBody BookingDto bookingDto)throws Exception {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			bookingService.updateBooking(bookingDto);

		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookingId}")
	public ResponseEntity<BookingDto> deleteBooking(@PathVariable("bookingId") Integer id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			bookingService.deleteBooking(id);
		} catch (BusinessException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
