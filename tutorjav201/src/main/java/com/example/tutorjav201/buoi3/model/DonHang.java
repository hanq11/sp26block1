package com.example.tutorjav201.buoi3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// id INT IDENTITY(1,1) PRIMARY KEY,
//         ten_khach_hang NVARCHAR(100),
//         ngay_mua DATE,
//         tong_tien DECIMAL(12,2),
//         da_thanh_toan BIT, -- 1: đã thanh toán, 0: chưa thanh toán
//         id_san_pham INT FOREIGN KEY REFERENCES san_pham(id)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_khach_hang")
    private String tenKhachHang;

    @Column(name = "ngay_mua")
    private String ngayMua;

    @Column(name = "tong_tien")
    private Float tongTien;

    @Column(name = "da_thanh_toan")
    private Boolean daThanhToan;

    @ManyToOne
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    private SanPham sanPham;
}
