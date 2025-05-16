package com.hotel.booking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "PHIEU_DANG_KY")
public class PhieuDangKy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaPDK")
    private Long maPDK;

    @ManyToOne
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "Maphong", referencedColumnName = "Maphong", nullable = false)
    private Phong phong;

    @Column(name = "Ngayden", nullable = false)
    private LocalDate ngayDen;

    @Column(name = "Ngaydi", nullable = false)
    private LocalDate ngayDi;

    @Column(name = "Tratruoc", precision = 18, scale = 2)
    private BigDecimal traTruoc;

    @Column(name = "Chuthich", length = 200)
    private String chuThich;

    @Column(name = "Trangthai", length = 20)
    private String trangThai;

    @Column(name = "tong_tien", precision = 18, scale = 2)
    private BigDecimal tongTien;

    // Constructors
    public PhieuDangKy() {}

    public PhieuDangKy(Long maPDK, KhachHang khachHang, Phong phong, LocalDate ngayDen, LocalDate ngayDi, 
                       BigDecimal traTruoc, String chuThich, String trangThai, BigDecimal tongTien) {
        this.maPDK = maPDK;
        this.khachHang = khachHang;
        this.phong = phong;
        this.ngayDen = ngayDen;
        this.ngayDi = ngayDi;
        this.traTruoc = traTruoc;
        this.chuThich = chuThich;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
    }

    // Getters and Setters
    public Long getMaPDK() {
        return maPDK;
    }

    public void setMaPDK(Long maPDK) {
        this.maPDK = maPDK;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public Phong getPhong() {
        return phong;
    }

    public void setPhong(Phong phong) {
        this.phong = phong;
    }

    public LocalDate getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(LocalDate ngayDen) {
        this.ngayDen = ngayDen;
    }

    public LocalDate getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(LocalDate ngayDi) {
        this.ngayDi = ngayDi;
    }

    public BigDecimal getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(BigDecimal traTruoc) {
        this.traTruoc = traTruoc;
    }

    public String getChuThich() {
        return chuThich;
    }

    public void setChuThich(String chuThich) {
        this.chuThich = chuThich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }
}
