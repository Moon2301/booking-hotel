package com.hotel.booking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.model.PhieuDangKy;
import com.hotel.booking.model.PhieuDangKyDTO;
import com.hotel.booking.model.Phong;
import com.hotel.booking.repository.KhachHangRepository;
import com.hotel.booking.repository.PhieuDangKyRepository;
import com.hotel.booking.repository.PhongRepository;

@Service
public class PhieuDangKyService {

    @Autowired
    private PhieuDangKyRepository phieuDangKyRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private PhongRepository phongRepository;

    public PhieuDangKy taoPhieuDangKy(PhieuDangKyDTO dto) {
        KhachHang khachHang = khachHangRepository.findById(dto.getMaKH())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));

        Phong phong = phongRepository.findById(dto.getMaPhong())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng"));

        // ✅ Kiểm tra trạng thái phòng
        if (!"Còn trống".equalsIgnoreCase(phong.getTrangThai())) {
            throw new RuntimeException("Phòng hiện không còn trống");
        }

        // ✅ Kiểm tra ngày đến và ngày đi
        LocalDate ngayHienTai = LocalDate.now();
        LocalDate ngayDen = LocalDate.parse(dto.getNgayDen());
        LocalDate ngayDi = LocalDate.parse(dto.getNgayDi());

        if (ngayDen.isBefore(ngayHienTai)) {
            throw new RuntimeException("Ngày đến phải lớn hơn hoặc bằng ngày hiện tại");
        }

        if (ngayDi.isBefore(ngayDen)) {
            throw new RuntimeException("Ngày đi phải sau ngày đến");
        }

        PhieuDangKy phieu = new PhieuDangKy();
        phieu.setKhachHang(khachHang);
        phieu.setPhong(phong);
        phieu.setNgayDen(ngayDen);
        phieu.setNgayDi(ngayDi);
        phieu.setTraTruoc(dto.getTraTruoc());
        phieu.setChuThich(dto.getChuThich());
        phieu.setTrangThai(dto.getTrangThai());
        phieu.setTongTien(dto.getTongTien());
        return phieuDangKyRepository.save(phieu);
    }

}
