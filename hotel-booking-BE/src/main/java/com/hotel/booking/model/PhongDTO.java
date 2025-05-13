package com.hotel.booking.model;



public class PhongDTO {
    private Long id;
    private String tenPhong;
    private String kieuPhong;
    private String loaiPhong;
    private String giaTien;
    private String moTa;
    private String trangThai;

    // Constructor, getters, setters

    public PhongDTO( Long id, String tenPhong, String kieuPhong, String loaiPhong, String giaTien, String moTa, String trangThai) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.kieuPhong = kieuPhong;
        this.loaiPhong = loaiPhong;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

        public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getKieuPhong() {
        return kieuPhong;
    }

    public void setKieuPhong(String kieuPhong) {
        this.kieuPhong = kieuPhong;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
