package com.ncu.college.tickets.service;

import com.ncu.college.tickets.dto.BookingDto;
import com.ncu.college.tickets.irepository.IBookingRepository;
import com.ncu.college.tickets.model.Booking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "BookingService")
public class BookingService {

    private final IBookingRepository bookingRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BookingService(IBookingRepository bookingRepository, ModelMapper modelMapper , RestClient.Builder restClientBuilder) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.getAllBookings();
        List<BookingDto> bookingDtos = new ArrayList<>();

        for (Booking b : bookings) {
            BookingDto dto = modelMapper.map(b, BookingDto.class);
            bookingDtos.add(dto);
        }

        return bookingDtos;
    }

    public BookingDto getBookingById(String bookingId) {
        Booking booking = bookingRepository.getBookingById(bookingId);
        if (booking == null) return null;
        return modelMapper.map(booking, BookingDto.class);
    }


    public List<BookingDto> getBookingsByUserId(String userId) {
        List<Booking> bookings = bookingRepository.getBookingsByUserId(userId);
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking b : bookings) {
            bookingDtos.add(modelMapper.map(b, BookingDto.class));
        }
        return bookingDtos;
    }


    public List<BookingDto> getBookingsByMovieId(String movieId) {
        List<Booking> bookings = bookingRepository.getBookingsByMovieId(movieId);
        List<BookingDto> bookingDtos = new ArrayList<>();
        for (Booking b : bookings) {
            bookingDtos.add(modelMapper.map(b, BookingDto.class));
        }
        return bookingDtos;
    }

    public boolean addBooking(BookingDto bookingDto) {
        try {
            Booking booking = modelMapper.map(bookingDto, Booking.class);
            int rows = bookingRepository.addBooking(booking);
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error in addBooking: " + e.getMessage());
            return false;
        }
    }


    public boolean updateBookingStatus(String bookingId, String status) {
        try {
            int rows = bookingRepository.updateBookingStatus(bookingId, status);
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error in updateBookingStatus: " + e.getMessage());
            return false;
        }
    }


    public boolean deleteBooking(String bookingId) {
        try {
            int rows = bookingRepository.deleteBooking(bookingId);
            return rows > 0;
        } catch (Exception e) {
            System.out.println("Error in deleteBooking: " + e.getMessage());
            return false;
        }
    }
}
