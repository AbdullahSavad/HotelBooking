package com.example.hotel.repository;

import com.example.hotel.entity.Booking; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
