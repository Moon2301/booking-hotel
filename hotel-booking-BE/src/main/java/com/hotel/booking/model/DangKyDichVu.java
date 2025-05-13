package com.hotel.booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DANG_KY_DICH_VU")
public class DangKyDichVu {

    @EmbeddedId
    private DangKyDichVuId id;

    @ManyToOne
    @MapsId("maPDK")
    @JoinColumn(name = "MaPDK", referencedColumnName = "MaPDK", nullable = false)
    private PhieuDangKy phieuDangKy;

    @ManyToOne
    @MapsId("maDV")
    @JoinColumn(name = "MaDV", referencedColumnName = "MaDV", nullable = false)
    private DichVu dichVu;

    @Column(name = "Soluong")
    private Integer soLuong;

    // Constructors
    public DangKyDichVu() {}

    public DangKyDichVu(PhieuDangKy phieuDangKy, DichVu dichVu, Integer soLuong) {
        this.phieuDangKy = phieuDangKy;
        this.dichVu = dichVu;
        this.soLuong = soLuong;
        this.id = new DangKyDichVuId(phieuDangKy.getMaPDK(), dichVu.getMaDV());
    }

    // Getters and Setters
    public DangKyDichVuId getId() {
        return id;
    }

    public void setId(DangKyDichVuId id) {
        this.id = id;
    }

    public PhieuDangKy getPhieuDangKy() {
        return phieuDangKy;
    }

    public void setPhieuDangKy(PhieuDangKy phieuDangKy) {
        this.phieuDangKy = phieuDangKy;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
}
