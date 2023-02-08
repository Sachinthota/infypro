package com.example.demo;

import java.math.BigInteger;
import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Booking {
	@Id
	int BookingId;
	@UpdateTimestamp
	Date BookingDate;
	String Name;
	String Email;
	BigInteger MobileNumber;

	public int getBookingId() {
		return BookingId;
	}
	public void setBookingId(int bookingId) {
		BookingId = bookingId;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public BigInteger getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "Booking [BookingId=" + BookingId + ", BookingDate=" + BookingDate + ", Name=" + Name + ", Email="
				+ Email + ", MobileNumber=" + MobileNumber + "]";
	}



}
