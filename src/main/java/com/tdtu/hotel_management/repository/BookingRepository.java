package com.tdtu.hotel_management.repository;

import com.tdtu.hotel_management.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
//    List<Booking> findByCustomerId(Long customerId);
}
