package com.example.sof302201sof3022.buoi2;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Cach 2: RequestParam
    // Chưa nói tự động ép kiểu
    @PostMapping("/login")
    public String login(@RequestParam("user") String user,
                        @RequestParam("pass") String pass,
                        Model model) {
        model.addAttribute("user", user);
        model.addAttribute("pass", pass);
        return "/buoi2/thongTin";
    }
}
