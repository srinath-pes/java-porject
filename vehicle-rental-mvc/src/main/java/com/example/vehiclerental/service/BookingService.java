package com.example.vehiclerental.service;

import com.example.vehiclerental.entity.*;
import com.example.vehiclerental.repository.BookingRepository;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() { return bookingRepository.findAll(); }

    public Booking save(Booking booking) {
        long days = Math.max(1, ChronoUnit.DAYS.between(booking.getStartDate(), booking.getEndDate()));
        booking.setTotalAmount(days * booking.getVehicle().getPricePerDay());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.getVehicle().setStatus(VehicleStatus.BOOKED);
        return bookingRepository.save(booking);
    }

    public void deleteById(Long id) { bookingRepository.deleteById(id); }
}
