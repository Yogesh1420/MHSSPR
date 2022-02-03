package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Booking;
import com.mph.entity.Userdetails;

@Repository
public class UserdaoImpl implements Userdao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@Override
	public void createUser(Userdetails userdetails) {
		getSession().saveOrUpdate(userdetails);
		System.out.println("User Details Added successfully...");
	
		
		
	}


	@Override
	public List<Userdetails> getAllUserdetails() {
			Query qry = getSession().createQuery("select e from Userdetails e");
			List<Userdetails> userlist = qry.list();
			System.out.println("user list from dao : " + userlist);
			return userlist;
		}


	@Override
	public List<Userdetails> updateUser(Userdetails userdetails) {
		Query qry = getSession().createQuery(" update Userdetails  e set username=:username,password=:pass,phone=:phone where userid=:userid");
		qry.setParameter("username", userdetails.getUsername());
		qry.setParameter("pass",userdetails.getPassword());
		qry.setParameter("phone", userdetails.getPhone());
		qry.setParameter("userid", userdetails.getUserid());
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Updated " + noofrows + " rows. ");
		}
		return getAllUserdetails();
		
	}


	@Override
	public Userdetails getUser(int userid) {
		Query qry = getSession().createQuery("from Userdetails e where userid=:userid");
		qry.setParameter("userid", userid);
		Userdetails user = (Userdetails) qry.uniqueResult();
		System.out.println("search result : " + user);
		return user;
	}


	@Override
	public List<Userdetails> deleteUserdetails(int userid) {
		Query qry = getSession().createQuery(" delete Userdetails  e where userid=:userid");
		qry.setParameter("userid", userid);
		int noofrows = qry.executeUpdate();
		if(noofrows>0) {
			System.out.println("Deleted " + noofrows + " rows. ");
		}
		return getAllUserdetails();
	}
	}
	


