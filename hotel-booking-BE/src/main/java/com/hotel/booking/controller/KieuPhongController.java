package com.hotel.booking.controller;

import com.hotel.booking.model.KieuPhong;
import com.hotel.booking.repository.KieuPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kieuphong")
public class KieuPhongController {

    @Autowired
    private KieuPhongRepository kieuPhongRepository;

    // Lấy tất cả kiểu phòng
    @GetMapping
    public List<KieuPhong> getAllKieuPhong() {
        return kieuPhongRepository.findAll();
    }

    // Lấy kiểu phòng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<KieuPhong> getKieuPhongById(@PathVariable Long id) {
        Optional<KieuPhong> kieuPhong = kieuPhongRepository.findById(id);
        return kieuPhong.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới kiểu phòng
    @PostMapping
    public KieuPhong createKieuPhong(@RequestBody KieuPhong kieuPhong) {
        return kieuPhongRepository.save(kieuPhong);
    }

    // Cập nhật kiểu phòng
    @PutMapping("/{id}")
    public ResponseEntity<KieuPhong> updateKieuPhong(@PathVariable Long id, @RequestBody KieuPhong kieuPhongDetails) {
        Optional<KieuPhong> optionalKieuPhong = kieuPhongRepository.findById(id);

        if (optionalKieuPhong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        KieuPhong kieuPhong = optionalKieuPhong.get();
        kieuPhong.setTenKP(kieuPhongDetails.getTenKP());
        kieuPhong.setGiaKP(kieuPhongDetails.getGiaKP());

        return ResponseEntity.ok(kieuPhongRepository.save(kieuPhong));
    }

    // Xóa kiểu phòng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKieuPhong(@PathVariable Long id) {
        if (!kieuPhongRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        kieuPhongRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
