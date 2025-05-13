package com.hotel.booking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "KIEU_PHONG")
public class KieuPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKP")
    private Long maKP;

    @Column(name = "TenKP", nullable = false)
    private String tenKP;

    @Column(name = "GiaKP", nullable = false, precision = 18, scale = 2)
    private BigDecimal giaKP;

    // Getters and Setters
    public Long getMaKP() {
        return maKP;
    }

    public void setMaKP(Long maKP) {
        this.maKP = maKP;
    }

    public String getTenKP() {
        return tenKP;
    }

    public void setTenKP(String tenKP) {
        this.tenKP = tenKP;
    }

    public BigDecimal getGiaKP() {
        return giaKP;
    }

    public void setGiaKP(BigDecimal giaKP) {
        this.giaKP = giaKP;
    }
}
