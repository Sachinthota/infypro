package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service implements BookingService {
	@Autowired
	Jpa j;
	
	@Override
	public String CreateBooking(Booking s) {
		System.out.println(s);
		Random d=new Random();
	    s.setBookingId(d.nextInt(10000));
		j.save(s);
		if(j.existsById(s.getBookingId()))
	    {
			  return "Booking done successfully, Booking id is:"+s.getBookingId();
	    }else return "Somthing went wrong please try again";
	}

	@Override
	public List ViewBookings() {
		if(j.findAll().isEmpty()) 
		{
			List<String> r=new ArrayList<>();
			r.add("No Bookings yet");
			return r;
		}else return j.findAll();
	}

	@Override
	public String delete(Integer id) {
		System.out.println("ss");
	    if(j.existsById(id))
	    {
	    	j.deleteById(id);	
	    	return "Booking deleted Successfully";
	    }else return "No Booking found with id "+id;   
	}

	@Override
	public String BookingModfiy(Booking s) {
		if(j.existsById(s.getBookingId()))
	    {
			Booking data=j.findById(s.getBookingId()).orElse(null);
			s.setBookingDate(data.getBookingDate());
			s.setName(data.getName());
			if(s.getMobileNumber()==null)s.setMobileNumber(data.getMobileNumber());
			if(s.getEmail().isEmpty())s.setEmail(data.getEmail());
			System.out.println(j.save(s));
			  return "Booking Modified successfully for Booking id :"+s.getBookingId();
	    }else return "No Booking found with id:"+s.getBookingId();
	}
	
	
}