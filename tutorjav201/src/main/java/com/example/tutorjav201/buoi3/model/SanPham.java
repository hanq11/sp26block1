package com.example.tutorjav201.buoi3.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// id INT IDENTITY(1,1) PRIMARY KEY,
//         ten_san_pham NVARCHAR(100),
//         gia_ban DECIMAL(10,2),
//         so_luong_ton INT
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ten_san_pham")
    private String tenSanPham;

    @Column(name="gia_ban")
    private Float giaBan;

}
