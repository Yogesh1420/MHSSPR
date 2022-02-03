package com.mph.dao;

import java.util.List;

import com.mph.entity.Booking;

public interface Bookingdao {
	public void Bookhall(Booking booking);
	public List<Booking> getBookingdetails();
	public List<Booking>deleteBookingdetails(int bookingid);

}
