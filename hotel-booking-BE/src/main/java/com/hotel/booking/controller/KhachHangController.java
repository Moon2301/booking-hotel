package com.hotel.booking.controller;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    @GetMapping("/{id}")
    public KhachHang getKhachHang(@PathVariable Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    @PutMapping("/{id}")
    public KhachHang updateKhachHang(@PathVariable Long id, @RequestBody KhachHang khachHang) {
        khachHang.setMaKH(id);
        return khachHangRepository.save(khachHang);
    }

    @DeleteMapping("/{id}")
    public void deleteKhachHang(@PathVariable Long id) {
        khachHangRepository.deleteById(id);
    }
}
