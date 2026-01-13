package com.example.sd20308jav201.buoi2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//
//-- Tạo bảng giang_vien với khóa ngoại truong_id
//        CREATE TABLE giang_vien (
//        id INT IDENTITY(1,1) PRIMARY KEY,
//        ten_giang_vien NVARCHAR(100) NOT NULL,
//        tuoi INT NOT NULL,
//        gioi_tinh NVARCHAR(10) NOT NULL,
//        truong_id INT NOT NULL,
//        FOREIGN KEY (truong_id) REFERENCES truong_hoc(id)
//        );
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giang_vien")
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_giang_vien")
    private String tenGiangVien;

    @Column(name = "tuoi")
    private Integer tuoi;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "truong_id", referencedColumnName = "id")
    private TruongHoc truongHoc;
}
