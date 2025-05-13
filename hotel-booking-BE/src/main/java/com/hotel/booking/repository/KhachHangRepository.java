package com.hotel.booking.repository;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Users findByID(String MaKH);
}
