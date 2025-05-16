package com.hotel.booking.model;

import java.math.BigDecimal;

public class PhieuDangKyDTO {
    private String tenKH;
    private String email;
    private String soDT;
    private String ngayDen;
    private String ngayDi;
    private Long idPhong;
    private BigDecimal traTruoc;
    private BigDecimal tongTien;
    private String chuThich;
    private String trangThai;

    public PhieuDangKyDTO() {
    }
    // Getters and Setters

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
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

    public Long getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Long idPhong) {
        this.idPhong = idPhong;
    }

    public BigDecimal getTraTruoc() {
        return traTruoc;
    }

    public void setTraTruoc(BigDecimal traTruoc) {
        this.traTruoc = traTruoc;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
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
 

}
