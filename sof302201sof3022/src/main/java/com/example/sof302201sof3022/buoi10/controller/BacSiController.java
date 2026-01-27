package com.example.sof302201sof3022.buoi10.controller;

import com.example.sof302201sof3022.buoi10.repository.BacSiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bac-si")
public class BacSiController {
    @Autowired
    BacSiRepository bacSiRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listBacSi", bacSiRepository.findAll());
        return "/buoi10/hien-thi";
    }
    // .findAll
    // findById
    //  delete
    // save - create, update
}
