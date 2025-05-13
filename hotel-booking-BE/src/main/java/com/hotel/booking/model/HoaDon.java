package com.hotel.booking.model;

import jakarta.persistence.*;

@Entity
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaHD")
    private Long maHD;

    @ManyToOne
    @JoinColumn(name = "MaPTT")
    private PhieuThanhToan phieuThanhToan;

    @Column(name = "Tenkhaithue")
    private String tenKhaiThue;

    @Column(name = "Masothue")
    private String maSoThue;

    @Column(name = "Dchikhaithue")
    private String diaChiKhaiThue;

    // Getters and Setters
    public Long getMaHD() {
        return maHD;
    }

    public void setMaHD(Long maHD) {
        this.maHD = maHD;
    }

    public PhieuThanhToan getPhieuThanhToan() {
        return phieuThanhToan;
    }

    public void setPhieuThanhToan(PhieuThanhToan phieuThanhToan) {
        this.phieuThanhToan = phieuThanhToan;
    }

    public String getTenKhaiThue() {
        return tenKhaiThue;
    }

    public void setTenKhaiThue(String tenKhaiThue) {
        this.tenKhaiThue = tenKhaiThue;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChiKhaiThue() {
        return diaChiKhaiThue;
    }

    public void setDiaChiKhaiThue(String diaChiKhaiThue) {
        this.diaChiKhaiThue = diaChiKhaiThue;
    }
}
