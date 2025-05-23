﻿
-- BẢNG KHÁCH HÀNG
CREATE TABLE KHACH_HANG (
    MaKH INT PRIMARY KEY IDENTITY(1,1),
    Gtinh NVARCHAR(10),
    TenKH NVARCHAR(100) NOT NULL,
    CMND NVARCHAR(20),
    Dchi NVARCHAR(200),
    SoDT NVARCHAR(20),
    Email NVARCHAR(100)
);

-- BẢNG USERS 
CREATE TABLE USERS (
    UserID INT PRIMARY KEY IDENTITY(1,1),
    MaKH INT NULL, -- chỉ áp dụng nếu user là customer
    Username NVARCHAR(50) NOT NULL UNIQUE,
    password_hash NVARCHAR(255) NOT NULL,
    Role NVARCHAR(20) NOT NULL DEFAULT 'customer', -- 'customer', 'admin' --
    FOREIGN KEY (MaKH) REFERENCES KHACH_HANG(MaKH)
);

CREATE TABLE LOAI_PHONG (
    MaLP INT PRIMARY KEY IDENTITY(1,1),
    TenLP NVARCHAR(50) NOT NULL,
    Trangbi NVARCHAR(200),
    GiaLP DECIMAL(18,2) NOT NULL 
);

-- BẢNG KIỂU PHÒNG
CREATE TABLE KIEU_PHONG (
    MaKP INT PRIMARY KEY IDENTITY(1,1),
    TenKP NVARCHAR(50) NOT NULL,
    GiaKP DECIMAL(18,2) NOT NULL 
);

-- BẢNG PHÒNG
CREATE TABLE PHONG (
    Maphong INT PRIMARY KEY IDENTITY(1,1),
    Tenphong NVARCHAR(50) NOT NULL,
    MaLP INT NOT NULL,
    MaKP INT NOT NULL,
    Mota NVARCHAR(200),
    Trangthai NVARCHAR(20) NOT NULL, 
    FOREIGN KEY (MaLP) REFERENCES LOAI_PHONG(MaLP),
    FOREIGN KEY (MaKP) REFERENCES KIEU_PHONG(MaKP)
);

-- BẢNG KHUYẾN MÃI
CREATE TABLE KHUYENMAI (
    MaKM INT PRIMARY KEY IDENTITY(1,1),
    MaLP INT NULL, -- Áp dụng cho loại phòng
    MaKP INT NULL, -- Áp dụng cho kiểu phòng
    Mota NVARCHAR(255), -- Mô tả khuyến mãi
    PhanTramGiam DECIMAL(5,2) NULL, -- Phần trăm giảm giá (null nếu không phải giảm giá theo phần trăm)
    GiaTriKhuyenMai DECIMAL(18,2) NULL, -- Giá trị giảm giá cố định (null nếu không phải giảm giá cố định)
    LoaiKhuyenMai NVARCHAR(50) NOT NULL, -- 'percentage' hoặc 'fixed'
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE,
    FOREIGN KEY (MaLP) REFERENCES LOAI_PHONG(MaLP),
    FOREIGN KEY (MaKP) REFERENCES KIEU_PHONG(MaKP)
);


CREATE TABLE PHIEU_DANG_KY (
    MaPDK INT PRIMARY KEY IDENTITY(1,1),
    MaKH INT NOT NULL,
    Maphong INT NOT NULL,
    Ngayden DATE NOT NULL,
    Ngaydi DATE NOT NULL,
    Tratruoc DECIMAL(18,2),
    Chuthich NVARCHAR(200),
    Trangthai NVARCHAR(20),
    TongTien DECIMAL(18,2) NOT NULL, 
    FOREIGN KEY (MaKH) REFERENCES KHACH_HANG(MaKH),
    FOREIGN KEY (Maphong) REFERENCES PHONG(Maphong)
);

-- BẢNG DỊCH VỤ
CREATE TABLE DICH_VU (
    MaDV INT PRIMARY KEY IDENTITY(1,1),
    TenDV NVARCHAR(100) NOT NULL,
    GiaDV DECIMAL(18,2) NOT NULL
);

-- BẢNG ĐĂNG KÝ DỊCH VỤ
CREATE TABLE DANG_KY_DICH_VU (
    MaPDK INT NOT NULL,
    MaDV INT NOT NULL,
    Soluong INT DEFAULT 1,
    PRIMARY KEY (MaPDK, MaDV),
    FOREIGN KEY (MaPDK) REFERENCES PHIEU_DANG_KY(MaPDK),
    FOREIGN KEY (MaDV) REFERENCES DICH_VU(MaDV)
);

-- BẢNG PHIẾU THANH TOÁN
CREATE TABLE PHIEU_THANH_TOAN (
    MaPTT INT PRIMARY KEY IDENTITY(1,1),
    MaPDK INT NOT NULL,
    SoNgay INT,
    Ngaythanhtoan DATE,
    Tongtien DECIMAL(18,2),
    ThueVAT DECIMAL(5,2),
    Tienphaitra DECIMAL(18,2),
    FOREIGN KEY (MaPDK) REFERENCES PHIEU_DANG_KY(MaPDK)
);

-- BẢNG HÓA ĐƠN
CREATE TABLE HOA_DON (
    MaHD INT PRIMARY KEY IDENTITY(1,1),
    MaPTT INT NOT NULL,
    Tenkhaithue NVARCHAR(100),
    Masothue NVARCHAR(20),
    Dchikhaithue NVARCHAR(200),
    FOREIGN KEY (MaPTT) REFERENCES PHIEU_THANH_TOAN(MaPTT)
);
