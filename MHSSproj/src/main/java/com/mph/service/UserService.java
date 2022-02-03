package com.mph.service;

import java.util.List;

import com.mph.entity.Userdetails;

public interface UserService {
	
	public void createUser(Userdetails userdetails);
	public List<Userdetails> getAllUserdetails();
	public List<Userdetails> updateUser(Userdetails userdetails);
	public Userdetails getUser(int userid);
	public List<Userdetails>deleteUserdetails(int userid);

}
