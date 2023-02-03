package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	Jpa j;
		
	@GetMapping
	public int S() {
		return 1;
	}
	@PostMapping("/createbooking")
	public String sm(@RequestBody Booking s)
	{
		j.save(s);
      return "Booking done successfully, booking id is:"+s.getId();

	}
	@GetMapping("/view")
	public List Sm() {
		if(j.findAll().isEmpty()) {
			List<String> r=new ArrayList<>();
			r.add("No Bookings yet");
			return r;
		}else return j.findAll();
	}
	@DeleteMapping("Delete/{id}")
	public String delete(@PathVariable Integer id) {
		
	    if(j.existsById(id))
	    {
	    	j.deleteById(id);	
	    	return "Booking deleted Successfully";
	    }else {
	    	return "No Booking found with id "+id;
	    	
	    }
	
		
	}
	
}
