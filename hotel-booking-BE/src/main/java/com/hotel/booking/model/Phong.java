package com.hotel.booking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PHONG")
public class Phong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Maphong")
    private Long id;

    @Column(name = "Tenphong")
    private String tenPhong;

    @ManyToOne
    @JoinColumn(name = "MaLP", referencedColumnName = "MaLP", nullable = false)
    private LoaiPhong loaiPhong;

    @ManyToOne
    @JoinColumn(name = "MaKP", referencedColumnName = "MaKP", nullable = false)
    private KieuPhong kieuPhong;

    @Column(name = "Mota")
    private String moTa;

    @Column(name = "Trangthai", nullable = false)
    private String trangThai;

    // Constructors
    public Phong() {}

    public Phong(Long id, String tenPhong, LoaiPhong loaiPhong, KieuPhong kieuPhong, String trangThai, String moTa) {
        this.id = id;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.kieuPhong = kieuPhong;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    // Getters and Setters
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

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
