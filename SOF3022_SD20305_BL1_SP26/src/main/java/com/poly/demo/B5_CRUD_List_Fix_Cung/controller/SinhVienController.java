package com.poly.demo.B5_CRUD_List_Fix_Cung.controller;

import com.poly.demo.B5_CRUD_List_Fix_Cung.enttiy.SinhVien;
import com.poly.demo.B5_CRUD_List_Fix_Cung.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SinhVienController {

    // goi => service
    // Bean => co bn cach goi bean // Slide 5
    @Autowired
    private SinhVienService service;

//    @Autowired
//    private ThucVatService tvSerivce;


    @GetMapping("sinh-vien/hien-thi")
    public String hienThiDanhSachSinhVien(Model m){
        m.addAttribute("lists",service.getLists());
        return "buoi4/sinh-viens";
    }

    @GetMapping("sinh-vien/add")
    public String hienThiFormAdd() {
        return "buoi4/add-sinh-vien";
    }

    @PostMapping("sinh-vien/add")
    public String addSinhVien(SinhVien sinhVien) {
        service.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }
}
