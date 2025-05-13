package com.hotel.booking.controller;

import com.hotel.booking.model.LoaiPhong;
import com.hotel.booking.repository.LoaiPhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loaiphong")
public class LoaiPhongController {

    @Autowired
    private LoaiPhongRepository loaiPhongRepository;

    // Lấy tất cả loại phòng
    @GetMapping
    public List<LoaiPhong> getAllLoaiPhong() {
        return loaiPhongRepository.findAll();
    }

    // Lấy loại phòng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<LoaiPhong> getLoaiPhongById(@PathVariable Long id) {
        Optional<LoaiPhong> loaiPhong = loaiPhongRepository.findById(id);
        return loaiPhong.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới loại phòng
    @PostMapping
    public LoaiPhong createLoaiPhong(@RequestBody LoaiPhong loaiPhong) {
        return loaiPhongRepository.save(loaiPhong);
    }

    // Cập nhật loại phòng
    @PutMapping("/{id}")
    public ResponseEntity<LoaiPhong> updateLoaiPhong(@PathVariable Long id, @RequestBody LoaiPhong loaiPhongDetails) {
        Optional<LoaiPhong> optionalLoaiPhong = loaiPhongRepository.findById(id);

        if (optionalLoaiPhong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        LoaiPhong loaiPhong = optionalLoaiPhong.get();
        loaiPhong.setTenLP(loaiPhongDetails.getTenLP());
        loaiPhong.setTrangbi(loaiPhongDetails.getTrangbi());
        loaiPhong.setGiaLP(loaiPhongDetails.getGiaLP());

        return ResponseEntity.ok(loaiPhongRepository.save(loaiPhong));
    }

    // Xóa loại phòng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoaiPhong(@PathVariable Long id) {
        if (!loaiPhongRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        loaiPhongRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
