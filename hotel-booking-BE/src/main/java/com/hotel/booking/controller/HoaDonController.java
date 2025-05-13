package com.hotel.booking.controller;

import com.hotel.booking.model.HoaDon;
import com.hotel.booking.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    // Lấy danh sách hóa đơn
    @GetMapping
    public List<HoaDon> getAllHoaDon() {
        return hoaDonRepository.findAll();
    }

    // Lấy thông tin hóa đơn theo mã
    @GetMapping("/{id}")
    public ResponseEntity<HoaDon> getHoaDonById(@PathVariable Long id) {
        Optional<HoaDon> hoaDon = hoaDonRepository.findById(id);
        return hoaDon.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo mới hóa đơn
    @PostMapping
    public HoaDon createHoaDon(@RequestBody HoaDon hoaDon) {
        return hoaDonRepository.save(hoaDon);
    }

    // Cập nhật hóa đơn
    @PutMapping("/{id}")
    public ResponseEntity<HoaDon> updateHoaDon(@PathVariable Long id, @RequestBody HoaDon hoaDonDetails) {
        Optional<HoaDon> hoaDonOptional = hoaDonRepository.findById(id);
        if (hoaDonOptional.isPresent()) {
            HoaDon hoaDon = hoaDonOptional.get();
            hoaDon.setTenKhaiThue(hoaDonDetails.getTenKhaiThue());
            hoaDon.setMaSoThue(hoaDonDetails.getMaSoThue());
            hoaDon.setDiaChiKhaiThue(hoaDonDetails.getDiaChiKhaiThue());
            hoaDon.setPhieuThanhToan(hoaDonDetails.getPhieuThanhToan());
            return ResponseEntity.ok(hoaDonRepository.save(hoaDon));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa hóa đơn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoaDon(@PathVariable Long id) {
        Optional<HoaDon> hoaDonOptional = hoaDonRepository.findById(id);
        if (hoaDonOptional.isPresent()) {
            hoaDonRepository.delete(hoaDonOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
