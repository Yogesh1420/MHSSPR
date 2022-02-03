package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.Userdao;
import com.mph.entity.Userdetails;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	public Userdao userdao;

	@Override
	public void createUser(Userdetails userdetails) {
		 userdao.createUser(userdetails);
		
		
	}

	@Override
	public List<Userdetails> getAllUserdetails() {
		return userdao.getAllUserdetails();
	}

	@Override
	public List<Userdetails> updateUser(Userdetails userdetails) {
		return userdao.updateUser(userdetails);
	}

	@Override
	public Userdetails getUser(int userid) {
		return userdao.getUser(userid);
	}

	@Override
	public List<Userdetails> deleteUserdetails(int userid) {
		return userdao.deleteUserdetails(userid);
	}

}
