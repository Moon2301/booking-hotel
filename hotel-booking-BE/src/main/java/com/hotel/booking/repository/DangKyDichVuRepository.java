package com.hotel.booking.repository;

import com.hotel.booking.model.DangKyDichVu;
import com.hotel.booking.model.DangKyDichVuId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangKyDichVuRepository extends JpaRepository<DangKyDichVu, DangKyDichVuId> {
}
