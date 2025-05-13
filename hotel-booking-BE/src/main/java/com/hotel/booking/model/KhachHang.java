package com.hotel.booking.model;

import jakarta.persistence.*;

@Entity
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maKH;
    
    private String gtinh;
    private String tenKH;
    private String cmnd;
    private String dchi;
    private String soDT;
    private String email;

    // Getters and Setters
    public Long getMaKH() {
        return maKH;
    }

    public KhachHang(Long maKH, String gtinh, String tenKH, String cmnd, String dchi, String soDT, String email) {
        this.maKH = maKH;
        this.gtinh = gtinh;
        this.tenKH = tenKH;
        this.cmnd = cmnd;
        this.dchi = dchi;
        this.soDT = soDT;
        this.email = email;
    }

    public void setMaKH(Long maKH) {
        this.maKH = maKH;
    }

    public String getGtinh() {
        return gtinh;
    }

    public void setGtinh(String gtinh) {
        this.gtinh = gtinh;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
