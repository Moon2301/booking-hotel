package com.hotel.booking.model;

import jakarta.persistence.*;

@Entity
public class DichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maDV;

    private String tenDV;
    private Double giaDV;

    // Getters and Setters
    public Long getMaDV() {
        return maDV;
    }

    public void setMaDV(Long maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Double getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(Double giaDV) {
        this.giaDV = giaDV;
    }
}
