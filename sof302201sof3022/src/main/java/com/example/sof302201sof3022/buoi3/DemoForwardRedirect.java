package com.example.sof302201sof3022.buoi3;

import com.example.sof302201sof3022.buoi2.Login;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/buoi3")
public class DemoForwardRedirect {
    @GetMapping("/url1")
    public String url1() {
        return "helloWorld/index";
    }

    @GetMapping("/url2")
    public String url2() {
        return "forward:/buoi3/url1";
    }

    // Su dung redirect khi du lieu bi thay doi - them, sua, xoa
    @GetMapping("/url3")
    public String url3() {
        return "redirect:/buoi3/url1";
    }

    @ResponseBody
    @GetMapping("/demo-json")
    public List<Login> demoJson() {
//        return new ArrayList<>(Arrays.asList(
//                new Login("abc", "123"),
//                new Login("bde", "234")
//        ));
        List<Login> danhSach = new ArrayList<>();
        danhSach.add(new Login("abc", "123"));
        danhSach.add(new Login("abc", "123"));
        return danhSach;
    }
}
