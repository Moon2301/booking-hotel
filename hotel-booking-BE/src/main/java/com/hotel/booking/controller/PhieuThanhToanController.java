package com.hotel.booking.controller;

import com.hotel.booking.model.PhieuThanhToan;
import com.hotel.booking.repository.PhieuThanhToanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phieuthanhtoan")
public class PhieuThanhToanController {

    @Autowired
    private PhieuThanhToanRepository phieuThanhToanRepository;

    // Lấy tất cả phiếu thanh toán
    @GetMapping
    public List<PhieuThanhToan> getAllPhieuThanhToan() {
        return phieuThanhToanRepository.findAll();
    }

    // Lấy phiếu thanh toán theo ID
    @GetMapping("/{id}")
    public ResponseEntity<PhieuThanhToan> getPhieuThanhToanById(@PathVariable Long id) {
        Optional<PhieuThanhToan> phieuThanhToan = phieuThanhToanRepository.findById(id);
        return phieuThanhToan.map(ResponseEntity::ok)
                             .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới phiếu thanh toán
    @PostMapping
    public PhieuThanhToan createPhieuThanhToan(@RequestBody PhieuThanhToan phieuThanhToan) {
        return phieuThanhToanRepository.save(phieuThanhToan);
    }

    // Cập nhật phiếu thanh toán
    @PutMapping("/{id}")
    public ResponseEntity<PhieuThanhToan> updatePhieuThanhToan(@PathVariable Long id, @RequestBody PhieuThanhToan phieuThanhToanDetails) {
        Optional<PhieuThanhToan> optionalPhieuThanhToan = phieuThanhToanRepository.findById(id);

        if (optionalPhieuThanhToan.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        PhieuThanhToan phieuThanhToan = optionalPhieuThanhToan.get();
        phieuThanhToan.setPhieuDangKy(phieuThanhToanDetails.getPhieuDangKy());
        phieuThanhToan.setSoNgay(phieuThanhToanDetails.getSoNgay());
        phieuThanhToan.setNgayThanhToan(phieuThanhToanDetails.getNgayThanhToan());
        phieuThanhToan.setTongTien(phieuThanhToanDetails.getTongTien());
        phieuThanhToan.setThueVAT(phieuThanhToanDetails.getThueVAT());
        phieuThanhToan.setTienPhaiTra(phieuThanhToanDetails.getTienPhaiTra());

        return ResponseEntity.ok(phieuThanhToanRepository.save(phieuThanhToan));
    }

    // Xóa phiếu thanh toán
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhieuThanhToan(@PathVariable Long id) {
        if (!phieuThanhToanRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        phieuThanhToanRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
