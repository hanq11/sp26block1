package com.example.chuademau1sof203.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaiHatRequest {
    private Integer id;
    private String tenBaiHat;
    private Float gia;
    private Boolean phatHanhDia;
    private String ngayRaMat;
}
