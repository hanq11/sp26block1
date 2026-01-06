package com.example.sof302201sof3022.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld(Model model) {
        model.addAttribute("ten", "SOF3022");
        return "helloWorld/index";
    }
}
