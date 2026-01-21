package com.example.sd21101sof203.buoi8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//id INT IDENTITY(1,1) PRIMARY KEY,
//        ten NVARCHAR(100),
//        email NVARCHAR(100),
//        tuoi INT,
//        dang_hoat_dong BIT
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NguoiDung {
    private Integer id;
    private String ten;
    private String email;
    private Integer tuoi;
    private Boolean dangHoatDong;
}
