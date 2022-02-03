package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.Bookingdao;
import com.mph.entity.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	public Bookingdao bookingdao;


	@Override
	public void Bookhall(Booking booking) {
		bookingdao.Bookhall(booking);
	
		
	}


	@Override
	public List<Booking> getBookingdetails() {
		return bookingdao.getBookingdetails();
		
		
	}


	@Override
	public List<Booking> deleteBookingdetails(int bookingid) {
		return bookingdao.deleteBookingdetails(bookingid);
	}

}
