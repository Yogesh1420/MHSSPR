package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Userdetails {

	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int userid;
		private String username;
		private String firstName;
		private String lastName;
		private String password;
		private String email;
		private String phone;
		private String address;
		private String city;
		private String state;
		public Userdetails() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Userdetails(int userid, String username, String firstName, String lastName, String password,
				String email, String phone, String address, String city, String state) {
			super();
			this.userid = userid;
			this.username = username;
			this.firstName = firstName;
			this.lastName = lastName;
			this.password = password;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.city = city;
			this.state = state;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		@Override
		public String toString() {
			return "Userdetails [userid=" + userid + ", username=" + username + ", firstName=" + firstName
					+ ", lastName=" + lastName + ", password=" + password + ", email=" + email + ", phone=" + phone
					+ ", address=" + address + ", city=" + city + ", state=" + state + "]";
		}
		
		
	}


