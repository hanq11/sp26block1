package com.poly.demo.B5_CRUD_List_Fix_Cung.enttiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SinhVien {
//    Tạo đối tượng SinhVien gồm các thuộc tính:
//    mssv - String, ten-String,
//    tuoi- int, diaChi - String,
//    gioiTinh - boolean và các constructor, getter, setter

    private String mssv;

    private String name;

    private int age;

    private String address;

    private boolean gender;

}
