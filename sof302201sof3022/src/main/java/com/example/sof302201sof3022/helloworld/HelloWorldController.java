package com.example.sof302201sof3022.helloworld;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
    @GetMapping({"/hello-world"})
    // @RequestMapping(value = "/hello-world", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("ten", "SOF3022");
        return "helloWorld/index";
    }

}
