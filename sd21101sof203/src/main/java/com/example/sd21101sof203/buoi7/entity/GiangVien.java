package com.example.sd21101sof203.buoi7.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class GiangVien {
    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String queQuan;
}
