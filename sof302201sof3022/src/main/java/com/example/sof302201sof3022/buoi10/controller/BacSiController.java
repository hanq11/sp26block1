package com.example.sof302201sof3022.buoi10.controller;

import com.example.sof302201sof3022.buoi10.model.BacSi;
import com.example.sof302201sof3022.buoi10.model.BenhVien;
import com.example.sof302201sof3022.buoi10.repository.BacSiRepository;
import com.example.sof302201sof3022.buoi10.repository.BenhVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bac-si")
public class BacSiController {
    @Autowired
    BacSiRepository bacSiRepository;

    @Autowired
    BenhVienRepository benhVienRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute("bacSi") BacSi bacSi) {
        model.addAttribute("listBacSi", bacSiRepository.findAll());
        return "/buoi10/hien-thi";
    }

    @ModelAttribute("listBenhVien")
    public List<BenhVien> getListBenhVien() {
        return benhVienRepository.findAll();
    }
    // .findAll
    // findById
    //  delete
    // save - create, update

    @PostMapping("/them")
    public String themBacSi(Model model, @Valid @ModelAttribute("bacSi") BacSi bacSi, Errors errors) {
        if(errors.hasErrors()) {
            return "/buoi10/hien-thi";
        }
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

//    @PostMapping("/them")
//    public String themBacSi(BacSi bacSi) {
//        bacSiRepository.save(bacSi);
//        return "redirect:/bac-si/hien-thi";
//    }


    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bacSi", bacSiRepository.findById(id).get());
        return "/buoi10/view-update";
    }

    @PostMapping("/sua")
    public String updateBacSi(BacSi bacSi) {
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/xoa")
    public String xoaBacSi(@RequestParam("id") Integer id) {
        bacSiRepository.deleteById(id);
        return "redirect:/bac-si/hien-thi";
    }
}
