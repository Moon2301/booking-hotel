package com.hotel.booking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "LOAI_PHONG")
public class LoaiPhong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaLP")
    private Long maLP;

    @Column(name = "TenLP", nullable = false)
    private String tenLP;

    @Column(name = "Trangbi")
    private String trangbi;

    @Column(name = "GiaLP", nullable = false, precision = 18, scale = 2)
    private BigDecimal giaLP;

    // Getters and Setters
    public Long getMaLP() {
        return maLP;
    }

    public void setMaLP(Long maLP) {
        this.maLP = maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public String getTrangbi() {
        return trangbi;
    }

    public void setTrangbi(String trangbi) {
        this.trangbi = trangbi;
    }

    public BigDecimal getGiaLP() {
        return giaLP;
    }

    public void setGiaLP(BigDecimal giaLP) {
        this.giaLP = giaLP;
    }
}
