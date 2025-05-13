package com.hotel.booking.controller;

import com.hotel.booking.model.DangKyDichVu;
import com.hotel.booking.model.DangKyDichVuId;
import com.hotel.booking.repository.DangKyDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dangkydichvu")
public class DangKyDichVuController {

    @Autowired
    private DangKyDichVuRepository dangKyDichVuRepository;

    // Lấy tất cả đăng ký dịch vụ
    @GetMapping
    public List<DangKyDichVu> getAllDangKyDichVu() {
        return dangKyDichVuRepository.findAll();
    }

    // Lấy đăng ký dịch vụ theo ID
    @GetMapping("/{maPDK}/{maDV}")
    public ResponseEntity<DangKyDichVu> getDangKyDichVuById(@PathVariable Long maPDK, @PathVariable Long maDV) {
        DangKyDichVuId id = new DangKyDichVuId(maPDK, maDV);
        Optional<DangKyDichVu> dangKyDichVu = dangKyDichVuRepository.findById(id);
        return dangKyDichVu.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới đăng ký dịch vụ
    @PostMapping
    public DangKyDichVu createDangKyDichVu(@RequestBody DangKyDichVu dangKyDichVu) {
        return dangKyDichVuRepository.save(dangKyDichVu);
    }

    // Cập nhật đăng ký dịch vụ
    @PutMapping("/{maPDK}/{maDV}")
    public ResponseEntity<DangKyDichVu> updateDangKyDichVu(@PathVariable Long maPDK, @PathVariable Long maDV, @RequestBody DangKyDichVu dangKyDichVuDetails) {
        DangKyDichVuId id = new DangKyDichVuId(maPDK, maDV);
        Optional<DangKyDichVu> optionalDangKyDichVu = dangKyDichVuRepository.findById(id);

        if (optionalDangKyDichVu.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DangKyDichVu dangKyDichVu = optionalDangKyDichVu.get();
        dangKyDichVu.setPhieuDangKy(dangKyDichVuDetails.getPhieuDangKy());
        dangKyDichVu.setDichVu(dangKyDichVuDetails.getDichVu());
        dangKyDichVu.setSoLuong(dangKyDichVuDetails.getSoLuong());

        return ResponseEntity.ok(dangKyDichVuRepository.save(dangKyDichVu));
    }

    // Xóa đăng ký dịch vụ
    @DeleteMapping("/{maPDK}/{maDV}")
    public ResponseEntity<Void> deleteDangKyDichVu(@PathVariable Long maPDK, @PathVariable Long maDV) {
        DangKyDichVuId id = new DangKyDichVuId(maPDK, maDV);
        if (!dangKyDichVuRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        dangKyDichVuRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
