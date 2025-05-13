package com.hotel.booking.controller;

import com.hotel.booking.model.KhuyenMai;
import com.hotel.booking.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khuyenmai")
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    // Lấy tất cả khuyến mãi
    @GetMapping
    public List<KhuyenMai> getAllKhuyenMai() {
        return khuyenMaiRepository.findAll();
    }

    // Lấy khuyến mãi theo ID
    @GetMapping("/{id}")
    public ResponseEntity<KhuyenMai> getKhuyenMaiById(@PathVariable Long id) {
        Optional<KhuyenMai> khuyenMai = khuyenMaiRepository.findById(id);
        return khuyenMai.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới khuyến mãi
    @PostMapping
    public KhuyenMai createKhuyenMai(@RequestBody KhuyenMai khuyenMai) {
        return khuyenMaiRepository.save(khuyenMai);
    }

    // Cập nhật khuyến mãi
    @PutMapping("/{id}")
    public ResponseEntity<KhuyenMai> updateKhuyenMai(@PathVariable Long id, @RequestBody KhuyenMai khuyenMaiDetails) {
        Optional<KhuyenMai> optionalKhuyenMai = khuyenMaiRepository.findById(id);

        if (optionalKhuyenMai.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        KhuyenMai khuyenMai = optionalKhuyenMai.get();
        khuyenMai.setLoaiPhong(khuyenMaiDetails.getLoaiPhong());
        khuyenMai.setKieuPhong(khuyenMaiDetails.getKieuPhong());
        khuyenMai.setMoTa(khuyenMaiDetails.getMoTa());
        khuyenMai.setPhanTramGiam(khuyenMaiDetails.getPhanTramGiam());
        khuyenMai.setGiaTriKhuyenMai(khuyenMaiDetails.getGiaTriKhuyenMai());
        khuyenMai.setLoaiKhuyenMai(khuyenMaiDetails.getLoaiKhuyenMai());
        khuyenMai.setNgayBatDau(khuyenMaiDetails.getNgayBatDau());
        khuyenMai.setNgayKetThuc(khuyenMaiDetails.getNgayKetThuc());

        return ResponseEntity.ok(khuyenMaiRepository.save(khuyenMai));
    }

    // Xóa khuyến mãi
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKhuyenMai(@PathVariable Long id) {
        if (!khuyenMaiRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        khuyenMaiRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
