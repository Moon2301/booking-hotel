package com.hotel.booking.model;

import java.math.BigDecimal;

public class PhieuDangKyDTO {
    private Long maKH;
    private Long maPhong;
    private String ngayDen;
    private String ngayDi;
    private BigDecimal traTruoc;
    private String chuThich;
    private String trangThai;
    private BigDecimal tongTien;
    public Long getMaKH() {
        return maKH;
    }
    public void setMaKH(Long maKH) {
        this.maKH = maKH;
    }
    public Long getMaPhong() {
        return maPhong;
    }
    public void setMaPhong(Long maPhong) {
        this.maPhong = maPhong;
    }
    public String getNgayDen() {
        return ngayDen;
    }
    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }
    public String getNgayDi() {
        return ngayDi;
    }
    public void setNgayDi(String ngayDi) {
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

    // Getters và Setters
}
