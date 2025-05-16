package com.hotel.booking.controller;

import com.hotel.booking.Service.PhongService;
import com.hotel.booking.model.Phong;
import com.hotel.booking.model.PhongDTO;
import com.hotel.booking.repository.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phong")
public class PhongController {

    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    private PhongService phongService;

    // Lấy tất cả phòng
    @GetMapping
    public List<PhongDTO> getRooms() {
        return phongService.getAllRooms();
    }

    // Lấy phòng theo ID// Trong Controller
    @GetMapping("/{id}")
    public PhongDTO getPhongById(@PathVariable Long id) {
        return phongService.getRoomById(id);
    }

    // Thêm mới phòng
    @PostMapping
    public Phong createPhong(@RequestBody Phong phong) {
        return phongRepository.save(phong);
    }

    // Cập nhật phòng
    @PutMapping("/{id}")
    public ResponseEntity<Phong> updatePhong(@PathVariable Long id, @RequestBody Phong phongDetails) {
        Optional<Phong> optionalPhong = phongRepository.findById(id);

        if (optionalPhong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Phong phong = optionalPhong.get();
        phong.setTenPhong(phongDetails.getTenPhong());
        phong.setLoaiPhong(phongDetails.getLoaiPhong());
        phong.setKieuPhong(phongDetails.getKieuPhong());
        phong.setTrangThai(phongDetails.getTrangThai());
        phong.setMoTa(phongDetails.getMoTa());

        return ResponseEntity.ok(phongRepository.save(phong));
    }

    // Xóa phòng
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhong(@PathVariable Long id) {
        if (!phongRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        phongRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
