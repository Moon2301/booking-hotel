package com.hotel.booking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.model.PhongDTO;
import com.hotel.booking.repository.PhongRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhongService {

    @Autowired
    private PhongRepository phongRepository;

public List<PhongDTO> getAllRooms() {
    return phongRepository.findAll().stream()
        .map(phong -> new PhongDTO(
            phong.getId(),
            phong.getTenPhong(),
            phong.getKieuPhong().getTenKP() , phong.getLoaiPhong().getTenLP(),
            phong.getKieuPhong().getGiaKP().add(phong.getLoaiPhong().getGiaLP()).toString(),
            phong.getMoTa(),
            phong.getTrangThai()
        ))
        .collect(Collectors.toList());
}

public PhongDTO getRoomById(Long id) {
    return phongRepository.findById(id)
        .map(phong -> new PhongDTO(
            phong.getId(),
            phong.getTenPhong(),
            phong.getKieuPhong().getTenKP(),
            phong.getLoaiPhong().getTenLP(),
            phong.getKieuPhong().getGiaKP().add(phong.getLoaiPhong().getGiaLP()).toString(),
            phong.getMoTa(),
            phong.getTrangThai()
        ))
        .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy phòng với ID: " + id));
}


}