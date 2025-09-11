package com.ncu.college.tickets.repository;

import java.util.List;

import com.ncu.college.tickets.irepository.IBookingRepository;
import com.ncu.college.tickets.model.Booking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "BookingRepository")
public class BookingRepository implements IBookingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Booking> getAllBookings() {
        String sql = "SELECT * FROM bookings";
        try {
            return jdbcTemplate.query(sql, new BookingRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching bookings: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Booking getBookingById(String bookingId) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{bookingId}, new BookingRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching booking by id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Booking> getBookingsByUserId(String userId) {
        String sql = "SELECT * FROM bookings WHERE user_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{userId}, new BookingRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching bookings by user id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<Booking> getBookingsByMovieId(String movieId) {
        String sql = "SELECT * FROM bookings WHERE movie_id = ?";
        try {
            return jdbcTemplate.query(sql, new Object[]{movieId}, new BookingRowMapper());
        } catch (Exception e) {
            System.out.println("Error fetching bookings by movie id: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (booking_id, user_id, movie_id, seats, status) VALUES (?, ?, ?, ?, ?)";
        try {
            return jdbcTemplate.update(sql,
                    booking.getBookingId(),
                    booking.getUserId(),
                    booking.getMovieId(),
                    booking.getSeats(),
                    booking.getStatus());
        } catch (Exception e) {
            System.out.println("Error adding booking: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateBookingStatus(String bookingId, String status) {
        String sql = "UPDATE bookings SET status = ? WHERE booking_id = ?";
        try {
            return jdbcTemplate.update(sql, status, bookingId);
        } catch (Exception e) {
            System.out.println("Error updating booking status: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int deleteBooking(String bookingId) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        try {
            return jdbcTemplate.update(sql, bookingId);
        } catch (Exception e) {
            System.out.println("Error deleting booking: " + e.getMessage());
            return 0;
        }
    }
}
