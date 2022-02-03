package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Booking;


@Repository
public class BookingdaoImpl implements Bookingdao {
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void Bookhall(Booking booking) {
		getSession().saveOrUpdate(booking);
		System.out.println("Booked successfully...");
		
		
	}

	@Override
	public List<Booking> getBookingdetails() {
		Query qry = getSession().createQuery("select e from Booking e");
		List<Booking>  booklist = qry.list();
		System.out.println("book list from dao : " + booklist);
		return booklist;
	}

	@Override
	public List<Booking> deleteBookingdetails(int bookingid) {
		Query qry = getSession().createQuery(" delete Booking  e where bookingid=:bookingid");
		qry.setParameter("bookingid", bookingid);
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getBookingdetails();
	}
	}


