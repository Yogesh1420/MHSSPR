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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mph.entity.Booking;

import com.mph.entity.Userdetails;
import com.mph.service.BookingService;
import com.mph.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "false",allowedHeaders =  "*"  ,origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE} )
public class MHSRestController {
	@Autowired
	public UserService userservice;
	
	
	
	@PostMapping("/createUser")
	public Userdetails createUser(@RequestBody Userdetails userdetails) {
		userservice.createUser(userdetails);
		return userdetails;
	}
	
	@GetMapping("/alluser")
	public ResponseEntity<List<Userdetails>> listAllUserdetails() {
		List<Userdetails> li = userservice.getAllUserdetails();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Userdetails>>(li,HttpStatus.OK);
	}
	@PutMapping("/updateuser")
	public ResponseEntity<List<Userdetails>> updateUser(@RequestBody Userdetails userdetails) {
		List<Userdetails> li = userservice.updateUser(userdetails);
		
		if (li.isEmpty()) {
			return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Userdetails>>(li,HttpStatus.OK);
	}
	@GetMapping("/getuser/{userid}")
    public ResponseEntity<Userdetails> getUser(@PathVariable("userid") int userid) {
        
       Userdetails userdetails = userservice.getUser(userid);
    	if (userdetails == null) {
			return new ResponseEntity<Userdetails>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Userdetails>(userdetails,HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteuser/{userid}")
	public ResponseEntity<List<Userdetails>> deleteUserdetails(@PathVariable("userid") int userid) {
		List<Userdetails> li = userservice.deleteUserdetails(userid);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Userdetails>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Userdetails>>(li,HttpStatus.OK);
	}
	
	

}
