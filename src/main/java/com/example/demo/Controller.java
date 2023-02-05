package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@Autowired
	Jpa j;
		
	@PostMapping(path="/CreateBooking",consumes = "application/json")
	public String sm(@RequestBody Booking s)
	{
		System.out.println(s);
		Random d=new Random();
	    s.setId(d.nextInt(10000));
		j.save(s);
		if(j.existsById(s.getId()))
	    {
			  return "Booking done successfully, Booking id is:"+s.getId();
	    }else {
	    	return "Somthing went wrong please try again";
	    	
	    }
	}
	
	@GetMapping(path="/ViewBookings",produces = "application/json")
	public List Sm() 
	{
		if(j.findAll().isEmpty()) {
			
			List<String> r=new ArrayList<>();
			r.add("No Bookings yet");
			return r;
		}else return j.findAll();
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
