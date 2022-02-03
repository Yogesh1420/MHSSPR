package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Booking;

import com.mph.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class BookingController {
	
	@Autowired
	BookingService bookingservice;
	
	@GetMapping("/bookdetails")
	public ResponseEntity<List<Booking>> listbookingdetails() {
		List<Booking> li = bookingservice.getBookingdetails();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
	}
	
	@PostMapping("/bookhall")
	public Booking Bookhall(@RequestBody Booking booking) {
		bookingservice.Bookhall(booking);
		return booking;
	}
	
	@DeleteMapping("/deletebooking/{bookingid}")
	public ResponseEntity<List<Booking>> deleteEmployee(@PathVariable("bookingid") int bookingid) {
		List<Booking> li = bookingservice.deleteBookingdetails(bookingid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Booking>>(li,HttpStatus.OK);
	}
}
