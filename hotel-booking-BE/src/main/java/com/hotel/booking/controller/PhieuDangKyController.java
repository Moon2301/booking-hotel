package com.hotel.booking.controller;

import com.hotel.booking.Service.PhieuDangKyService;
import com.hotel.booking.model.PhieuDangKy;
import com.hotel.booking.model.PhieuDangKyDTO;
import com.hotel.booking.repository.PhieuDangKyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phieudangky")
public class PhieuDangKyController {

    @Autowired
    private PhieuDangKyRepository phieuDangKyRepository;
    @Autowired
    private PhieuDangKyService phieuDangKyService;

    // Lấy tất cả phiếu đăng ký
    @GetMapping
    public List<PhieuDangKy> getAllPhieuDangKy() {
        return phieuDangKyRepository.findAll();
    }

    // Lấy phiếu đăng ký theo ID
    @GetMapping("/{id}")
    public ResponseEntity<PhieuDangKy> getPhieuDangKyById(@PathVariable Long id) {
        Optional<PhieuDangKy> phieuDangKy = phieuDangKyRepository.findById(id);
        return phieuDangKy.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới phiếu đăng ký
    @PostMapping
    public ResponseEntity<?> taoPhieu(@RequestBody PhieuDangKyDTO dto) {
        try {
            PhieuDangKy phieu = phieuDangKyService.taoPhieuDangKy(dto);
            return ResponseEntity.ok(phieu);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST) // => dùng 400 thay vì 500
                    .body(Collections.singletonMap("error", e.getMessage())); // Trả về dạng JSON
        }
    }

    // Cập nhật phiếu đăng ký
    @PutMapping("/{id}")
    public ResponseEntity<PhieuDangKy> updatePhieuDangKy(@PathVariable Long id,
            @RequestBody PhieuDangKy phieuDangKyDetails) {
        Optional<PhieuDangKy> optionalPhieuDangKy = phieuDangKyRepository.findById(id);

        if (optionalPhieuDangKy.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PhieuDangKy phieuDangKy = optionalPhieuDangKy.get();
        phieuDangKy.setKhachHang(phieuDangKyDetails.getKhachHang());
        phieuDangKy.setPhong(phieuDangKyDetails.getPhong());
        phieuDangKy.setNgayDen(phieuDangKyDetails.getNgayDen());
        phieuDangKy.setNgayDi(phieuDangKyDetails.getNgayDi());
        phieuDangKy.setTraTruoc(phieuDangKyDetails.getTraTruoc());
        phieuDangKy.setChuThich(phieuDangKyDetails.getChuThich());
        phieuDangKy.setTrangThai(phieuDangKyDetails.getTrangThai());
        phieuDangKy.setTongTien(phieuDangKyDetails.getTongTien());

        return ResponseEntity.ok(phieuDangKyRepository.save(phieuDangKy));
    }

    // Xóa phiếu đăng ký
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhieuDangKy(@PathVariable Long id) {
        if (!phieuDangKyRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        phieuDangKyRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
