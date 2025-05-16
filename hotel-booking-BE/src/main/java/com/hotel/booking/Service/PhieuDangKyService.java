package com.hotel.booking.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.model.KhachHang;
import com.hotel.booking.model.PhieuDangKy;
import com.hotel.booking.model.PhieuDangKyDTO;
import com.hotel.booking.model.Phong;
import com.hotel.booking.model.Users;
import com.hotel.booking.repository.KhachHangRepository;
import com.hotel.booking.repository.PhieuDangKyRepository;
import com.hotel.booking.repository.PhongRepository;
import com.hotel.booking.repository.UsersRepository;

@Service
public class PhieuDangKyService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private PhongRepository phongRepository;
    @Autowired
    private PhieuDangKyRepository phieuDangKyRepository;

    public PhieuDangKy taoPhieuDangKy(PhieuDangKyDTO dto) {
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new RuntimeException("Email không được để trống");
        }

        //  Kiểm tra ngày đến và ngày đi hợp lệ
        LocalDate ngayDen;
        LocalDate ngayDi;
        try {
            ngayDen = LocalDate.parse(dto.getNgayDen());
            ngayDi = LocalDate.parse(dto.getNgayDi());
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Định dạng ngày không hợp lệ.");
        }

        if (ngayDen.isBefore(LocalDate.now())) {
            throw new RuntimeException("Ngày đến phải từ hôm nay trở đi.");
        }

        if (ngayDi.isBefore(ngayDen)) {
            throw new RuntimeException("Ngày đi phải sau ngày đến.");
        }

        //  Kiểm tra phòng tồn tại và còn trống
        Phong phong = phongRepository.findById(dto.getIdPhong())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phòng có ID: " + dto.getIdPhong()));

        if (!"Còn trống".equalsIgnoreCase(phong.getTrangThai())) {
            throw new RuntimeException("Phòng hiện không còn trống.");
        }

                KhachHang kh = khachHangRepository.findByEmail(dto.getEmail()).orElse(null);
        if (kh == null) {
            kh = new KhachHang();
            kh.setTenKH(dto.getTenKH());
            kh.setSoDT(dto.getSoDT());
            kh.setEmail(dto.getEmail());
            khachHangRepository.save(kh);
            Users user = new Users();
            user.setUsername(dto.getEmail());
            user.setPasswordHash(dto.getSoDT());
            user.setRole("customer");
            usersRepository.save(user);
        }

        // Tạo phiếu đăng ký
        PhieuDangKy phieu = new PhieuDangKy();
        phieu.setKhachHang(kh);
        phieu.setPhong(phong);
        phieu.setNgayDen(ngayDen);
        phieu.setNgayDi(ngayDi);
        phieu.setTraTruoc(dto.getTraTruoc());
        phieu.setTongTien(dto.getTongTien());
        phieu.setChuThich(dto.getChuThich());
        phieu.setTrangThai(dto.getTrangThai() != null ? dto.getTrangThai() : "Đã đặt");
        phong.setTrangThai("Đã đặt"); 
        phongRepository.save(phong);

        return phieuDangKyRepository.save(phieu);
    }

}
