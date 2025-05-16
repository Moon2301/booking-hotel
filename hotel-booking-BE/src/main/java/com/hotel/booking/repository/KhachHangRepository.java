package com.hotel.booking.repository;

import com.hotel.booking.model.KhachHang;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Optional<KhachHang> findByEmail(String email);
}
