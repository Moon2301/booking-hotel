package com.hotel.booking.repository;

import com.hotel.booking.model.PhieuThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThanhToanRepository extends JpaRepository<PhieuThanhToan, Long> {
    
}
