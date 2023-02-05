package com.example.demo;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@Id
	int id;
	@UpdateTimestamp
	Date bookingdate;
	String name;
	String email;
	BigInteger Mobilenumber;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getMobilenumber() {
		return Mobilenumber;
	}
	public void setMobilenumber(BigInteger mobilenumber) {
		Mobilenumber = mobilenumber;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingdate=" + bookingdate + ", name=" + name + ", email=" + email
				+ ", Mobilenumber=" + Mobilenumber + "]";
	}

}
