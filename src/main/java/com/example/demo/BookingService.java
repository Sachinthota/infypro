package com.example.demo;

import java.util.List;

public interface BookingService {
	public String CreateBooking(Booking s);
	public List ViewBookings() ;
	public String delete(Integer id);
	public String BookingModfiy(Booking s);
}
