package com.ncu.college.tickets.dto;

import java.util.Date;

public class BookingDto {
    public String bookingId;
    public String userId;
    public String movieId;
    public Date bookingDate;
    public int seats;
    public String status;

    // Default constructor
    public BookingDto() {
    }

    // Parameterized constructor
    public BookingDto(String bookingId, String userId, String movieId, Date bookingDate, int seats, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.movieId = movieId;
        this.bookingDate = bookingDate;
        this.seats = seats;
        this.status = status;
    }

    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
