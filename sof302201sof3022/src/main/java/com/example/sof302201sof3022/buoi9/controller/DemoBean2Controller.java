package com.example.sof302201sof3022.buoi9.controller;

import com.example.sof302201sof3022.buoi9.config.GiangVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo-bean2")
public class DemoBean2Controller {
    @Qualifier("bean1")
    @Autowired
    GiangVien giangVien;

    @GetMapping("/hien-thi")
    public GiangVien hienThi() {
        return giangVien;
    }
}
