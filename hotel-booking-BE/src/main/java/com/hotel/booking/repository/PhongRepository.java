package com.hotel.booking.repository;

import com.hotel.booking.model.Phong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhongRepository extends JpaRepository<Phong, Long> {
    
}