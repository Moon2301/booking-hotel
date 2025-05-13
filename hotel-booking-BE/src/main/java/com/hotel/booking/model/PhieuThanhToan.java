package com.hotel.booking.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PHIEU_THANH_TOAN")
public class PhieuThanhToan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPTT;

    @ManyToOne
    @JoinColumn(name = "MaPDK", referencedColumnName = "MaPDK", nullable = false)
    private PhieuDangKy phieuDangKy;

    @Column(name = "SoNgay")
    private Integer soNgay;

    @Column(name = "Ngaythanhtoan")
    private Date ngayThanhToan;

    @Column(name = "Tongtien")
    private Double tongTien;

    @Column(name = "ThueVAT")
    private Double thueVAT;

    @Column(name = "Tienphaitra")
    private Double tienPhaiTra;

    // Constructors
    public PhieuThanhToan() {}

    public PhieuThanhToan(PhieuDangKy phieuDangKy, Integer soNgay, Date ngayThanhToan, Double tongTien, Double thueVAT, Double tienPhaiTra) {
        this.phieuDangKy = phieuDangKy;
        this.soNgay = soNgay;
        this.ngayThanhToan = ngayThanhToan;
        this.tongTien = tongTien;
        this.thueVAT = thueVAT;
        this.tienPhaiTra = tienPhaiTra;
    }

    // Getters and Setters
    public Long getMaPTT() {
        return maPTT;
    }

    public void setMaPTT(Long maPTT) {
        this.maPTT = maPTT;
    }

    public PhieuDangKy getPhieuDangKy() {
        return phieuDangKy;
    }

    public void setPhieuDangKy(PhieuDangKy phieuDangKy) {
        this.phieuDangKy = phieuDangKy;
    }

    public Integer getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(Integer soNgay) {
        this.soNgay = soNgay;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Double getThueVAT() {
        return thueVAT;
    }

    public void setThueVAT(Double thueVAT) {
        this.thueVAT = thueVAT;
    }

    public Double getTienPhaiTra() {
        return tienPhaiTra;
    }

    public void setTienPhaiTra(Double tienPhaiTra) {
        this.tienPhaiTra = tienPhaiTra;
    }
}
