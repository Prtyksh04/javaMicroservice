package com.ncu.college.tickets.controller;

import com.ncu.college.tickets.dto.BookingDto;
import com.ncu.college.tickets.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookings")
@RestController
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/all")
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public BookingDto getBookingById(@PathVariable String bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @GetMapping("/user/{userId}")
    public List<BookingDto> getBookingsByUser(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }


    @GetMapping("/movie/{movieId}")
    public List<BookingDto> getBookingsByMovie(@PathVariable String movieId) {
        return bookingService.getBookingsByMovieId(movieId);
    }

    @PostMapping("/add")
    public String addBooking(@RequestBody BookingDto bookingDto) {
        boolean success = bookingService.addBooking(bookingDto);
        return success ? "Booking added successfully" : "Failed to add booking";
    }

    @PutMapping("/updateStatus/{bookingId}")
    public String updateBookingStatus(@PathVariable String bookingId, @RequestParam String status) {
        boolean success = bookingService.updateBookingStatus(bookingId, status);
        return success ? "Booking status updated successfully" : "Failed to update status";
    }


    @DeleteMapping("/delete/{bookingId}")
    public String deleteBooking(@PathVariable String bookingId) {
        boolean success = bookingService.deleteBooking(bookingId);
        return success ? "Booking deleted successfully" : "Failed to delete booking";
    }
}