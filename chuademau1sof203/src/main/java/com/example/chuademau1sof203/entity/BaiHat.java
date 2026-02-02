package com.example.chuademau1sof203.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//[ten_bai_hat] nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
//        [ten_tac_gia] nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
//        [thoi_luong] int  NULL,
//        [ngay_san_xuat] date  NULL,
//        [gia] float(53)  NULL,
//        [ca_si_id] int  NULL,
//        [phat_hanh_dia] bit  NULL,
//        [ngay_ra_mat] date  NULL
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class
BaiHat {
    private Integer id;
    private String tenBaiHat;
    private Float gia;
    private Boolean phatHanhDia;
    private String ngayRaMat;
}
