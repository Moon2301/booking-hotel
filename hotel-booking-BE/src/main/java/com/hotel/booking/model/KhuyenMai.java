package com.hotel.booking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "KHUYENMAI")
public class KhuyenMai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKM")
    private Long maKM;

    @ManyToOne
    @JoinColumn(name = "MaLP", referencedColumnName = "MaLP")
    private LoaiPhong loaiPhong;

    @ManyToOne
    @JoinColumn(name = "MaKP", referencedColumnName = "MaKP")
    private KieuPhong kieuPhong;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "PhanTramGiam", precision = 5, scale = 2)
    private BigDecimal phanTramGiam;

    @Column(name = "GiaTriKhuyenMai", precision = 18, scale = 2)
    private BigDecimal giaTriKhuyenMai;

    @Column(name = "LoaiKhuyenMai", nullable = false)
    private String loaiKhuyenMai;

    @Column(name = "NgayBatDau", nullable = false)
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDate ngayKetThuc;

    // Constructors
    public KhuyenMai() {}

    public KhuyenMai(Long maKM, LoaiPhong loaiPhong, KieuPhong kieuPhong, String moTa, BigDecimal phanTramGiam, 
                     BigDecimal giaTriKhuyenMai, String loaiKhuyenMai, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maKM = maKM;
        this.loaiPhong = loaiPhong;
        this.kieuPhong = kieuPhong;
        this.moTa = moTa;
        this.phanTramGiam = phanTramGiam;
        this.giaTriKhuyenMai = giaTriKhuyenMai;
        this.loaiKhuyenMai = loaiKhuyenMai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    // Getters and Setters
    public Long getMaKM() {
        return maKM;
    }

    public void setMaKM(Long maKM) {
        this.maKM = maKM;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public KieuPhong getKieuPhong() {
        return kieuPhong;
    }

    public void setKieuPhong(KieuPhong kieuPhong) {
        this.kieuPhong = kieuPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public BigDecimal getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(BigDecimal phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public BigDecimal getGiaTriKhuyenMai() {
        return giaTriKhuyenMai;
    }

    public void setGiaTriKhuyenMai(BigDecimal giaTriKhuyenMai) {
        this.giaTriKhuyenMai = giaTriKhuyenMai;
    }

    public String getLoaiKhuyenMai() {
        return loaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String loaiKhuyenMai) {
        this.loaiKhuyenMai = loaiKhuyenMai;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
