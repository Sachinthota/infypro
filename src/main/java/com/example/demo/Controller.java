package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@Autowired
	Jpa j;
		
	@PostMapping(path="/CreateBooking",consumes = "application/json")
	public String CreateBooking(@RequestBody Booking s)
	{
		System.out.println(s);
		Random d=new Random();
	    s.setBookingId(d.nextInt(10000));
		j.save(s);
		if(j.existsById(s.getBookingId()))
	    {
			  return "Booking done successfully, Booking id is:"+s.getBookingId();
	    }else return "Somthing went wrong please try again";
	   
	}

	@GetMapping(path="/ViewBookings",produces = "application/json")
	public List ViewBookings() 
	{
		if(j.findAll().isEmpty()) 
		{
			List<String> r=new ArrayList<>();
			r.add("No Bookings yet");
			return r;
		}else return j.findAll();
	}
	
	@PutMapping(path="/BookingModify",consumes = "application/json")
	public String BookingModfiy(@RequestBody Booking s)
	{
		System.out.println(s);
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
	
	@DeleteMapping("Delete/{id}")
	public String delete(@PathVariable Integer id) 
	{
		
	    if(j.existsById(id))
	    {
	    	j.deleteById(id);	
	    	return "Booking deleted Successfully";
	    }else return "No Booking found with id "+id;   
	}
	

	
}
