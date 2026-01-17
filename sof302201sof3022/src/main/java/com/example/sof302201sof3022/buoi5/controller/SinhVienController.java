package com.example.sof302201sof3022.buoi5.controller;

import com.example.sof302201sof3022.buoi5.model.SinhVien;
import com.example.sof302201sof3022.buoi5.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService; //(Ioc/DI)

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listSinhVien", sinhVienService.getAll());
        return "/buoi5/hien-thi";
    }

    @PostMapping("/them")
    public String themSinhVien(SinhVien sinhVien) {
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/hien-thi";
    }
}
