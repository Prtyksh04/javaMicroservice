package com.ncu.college.tickets.irepository;

import java.util.List;
import com.ncu.college.tickets.model.Booking;

public interface IBookingRepository {

    List<Booking> getAllBookings();

    Booking getBookingById(String bookingId);

    List<Booking> getBookingsByUserId(String userId);

    List<Booking> getBookingsByMovieId(String movieId);

    int addBooking(Booking booking);

    int updateBookingStatus(String bookingId, String status);

    int deleteBooking(String bookingId);
}
