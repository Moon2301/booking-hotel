package com.hotel.booking.repository;

import com.hotel.booking.model.PhieuDangKy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuDangKyRepository extends JpaRepository<PhieuDangKy, Long> {
    // Bạn có thể thêm các phương thức tùy chỉnh tại đây nếu cần
}
