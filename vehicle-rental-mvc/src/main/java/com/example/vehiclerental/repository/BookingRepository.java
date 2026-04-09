package com.example.vehiclerental.repository;

import com.example.vehiclerental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
