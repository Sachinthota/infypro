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
	BookingService b;
		
	@PostMapping(path="/CreateBooking",consumes = "application/json")
	public String CreateBooking(@RequestBody Booking s)
	{
		return b.CreateBooking(s);
	   
	}

	@GetMapping(path="/ViewBookings",produces = "application/json")
	public List ViewBookings() 
	{
       return b.ViewBookings();
	}
	
	@PutMapping(path="/BookingModify",consumes = "application/json")
	public String BookingModfiy(@RequestBody Booking s)
	{
     return b.BookingModfiy(s);
	   
	}
	
	@DeleteMapping("Delete/{id}")
	public String delete(@PathVariable Integer id) 
	{
		  return b.delete(id);
 
	}
	

	
}
