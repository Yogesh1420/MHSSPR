package com.mph.service;



import java.util.List;

import com.mph.entity.Booking;


public interface BookingService {
	public void Bookhall(Booking booking);
	public List<Booking> getBookingdetails();
	public List<Booking> deleteBookingdetails(int bookingid);

}
