package com.hotel.booking.controller;

import com.hotel.booking.model.DichVu;
import com.hotel.booking.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dichvu")
public class DichVuController {

    @Autowired
    private DichVuRepository dichVuRepository;

    // GET all
    @GetMapping
    public List<DichVu> getAllDichVu() {
        return dichVuRepository.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Optional<DichVu> getDichVuById(@PathVariable Long id) {
        return dichVuRepository.findById(id);
    }

    // POST (create)
    @PostMapping
    public DichVu createDichVu(@RequestBody DichVu dichVu) {
        return dichVuRepository.save(dichVu);
    }

    // PUT (update)
    @PutMapping("/{id}")
    public DichVu updateDichVu(@PathVariable Long id, @RequestBody DichVu details) {
        DichVu dichVu = dichVuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Dịch Vụ với ID: " + id));

        dichVu.setTenDV(details.getTenDV());
        dichVu.setGiaDV(details.getGiaDV());

        return dichVuRepository.save(dichVu);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDichVu(@PathVariable Long id) {
        dichVuRepository.deleteById(id);
    }
}
