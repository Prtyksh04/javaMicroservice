package com.ncu.college.tickets.repository;

import org.springframework.jdbc.core.RowMapper;
import com.ncu.college.tickets.model.Booking;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookingRowMapper implements RowMapper<Booking> {

    @Override
    public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
        if (rs == null) {
            return null;
        }

        Booking booking = new Booking();
        booking.setBookingId(rs.getString("booking_id"));   // maps to column booking_id
        booking.setUserId(rs.getString("user_id"));         // maps to column user_id
        booking.setMovieId(rs.getString("movie_id"));       // maps to column movie_id
        booking.setBookingDate(rs.getTimestamp("booking_date")); // maps to column booking_date
        booking.setSeats(rs.getInt("seats"));              // maps to column seats
        booking.setStatus(rs.getString("status"));         // maps to column status

        return booking;
    }
}
