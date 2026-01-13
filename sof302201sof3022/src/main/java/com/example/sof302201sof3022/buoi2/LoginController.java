package com.example.sof302201sof3022.buoi2;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequestMapping("/buoi2")
public class LoginController {
    @GetMapping("/show-form")
    public String showForm() {
        return "/buoi2/form";
    }
    // Cach 1: dung HttpServletRequest
//    @PostMapping("/login")
//    public String login(HttpServletRequest request, Model model) {
//        model.addAttribute("user", request.getParameter("user"));
//        model.addAttribute("pass", request.getParameter("pass"));
//        return "/buoi2/thongTin";
//    }

//    // Cach 2: RequestParam
//    // Chưa nói tự động ép kiểu
//    @PostMapping("/login")
//    public String login(@RequestParam("user") String user,
//                        @RequestParam("pass") String pass,
//                        Model model) {
//        model.addAttribute("user", user);
//        model.addAttribute("pass", pass);
//        return "/buoi2/thongTin";
//    }

    // Cach 3: su dung bean class
    @PostMapping("/login")
    public String login(Login login, Model model) {
        model.addAttribute("user", login.getUser());
        model.addAttribute("pass", login.getPass());
        return "/buoi2/thongTin";
    }

    @ResponseBody
    @GetMapping("/demo-path-variable/{user}")
    public void demoPathVariable(@PathVariable("user") String user) {
        System.out.println(user);
    }

    // Demo @ModelAttribute
    @PostMapping("/model-attr2")
    public String modelAttr2(@ModelAttribute("login") Login login) {
        return "/buoi2/thongTin";
    }

    @ModelAttribute("message")
    public String getMessage() {
        return "Day la cach su dung model attribute thu 3";
    }

}
