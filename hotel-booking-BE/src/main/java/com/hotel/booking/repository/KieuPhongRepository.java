package com.hotel.booking.repository;

import com.hotel.booking.model.KieuPhong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KieuPhongRepository extends JpaRepository<KieuPhong, Long> {
    
}
