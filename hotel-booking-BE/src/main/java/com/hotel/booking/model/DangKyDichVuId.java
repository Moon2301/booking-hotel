package com.hotel.booking.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DangKyDichVuId implements Serializable {

    @Column(name = "MaPDK")
    private Long maPDK;

    @Column(name = "MaDV")
    private Long maDV;

    // Constructors, Getters, Setters, hashCode, equals
    public DangKyDichVuId() {}

    public DangKyDichVuId(Long maPDK, Long maDV) {
        this.maPDK = maPDK;
        this.maDV = maDV;
    }

    public Long getMaPDK() {
        return maPDK;
    }

    public void setMaPDK(Long maPDK) {
        this.maPDK = maPDK;
    }

    public Long getMaDV() {
        return maDV;
    }

    public void setMaDV(Long maDV) {
        this.maDV = maDV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DangKyDichVuId that = (DangKyDichVuId) o;
        return maPDK.equals(that.maPDK) && maDV.equals(that.maDV);
    }

    @Override
    public int hashCode() {
        return 31 * maPDK.hashCode() + maDV.hashCode();
    }
}
