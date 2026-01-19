package com.poly.demo.B2_LamViecVoiForm.controller;

import com.poly.demo.B2_LamViecVoiForm.request.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    /**
     * HTTP Methods: GET, POST, PUT, DELETE, PATCH ...
     * GET: Hiển thị, Lấy,.... < READ>
     * POST: Add : CREATE
     * PUT: Update
     * DELETE
     * RESTFULL API
     * J5: Chi lam viec vs 2 phuong HTTP Method: GET & POST
     * O J5
     *  => GET: K lam viec vs form
     *  => POST: Xu ly form (Thuong dung trong login, add, update..)
     */
    /**
     * Khi class duoc danh dau la @Controller
     * => TAT CA CAC HAM TRONG CLASS LUON LUON TRA VE STRING (RETURN VIEW)
     */

    // 2 cach de danh dau day la phuong thuc get
    // C1: GetMapping
//    @GetMapping("login")
    // C2: RequestMapping
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String hienThiFormLogin(Model m) {
        // Truyen gia tri tu controller -> thymeaft
        // Model(.ui) -> addAttribute
        String message = "Test J5";
        m.addAttribute("test", message);
        // Tao doi tuong rong de validate
        m.addAttribute("login1", new LoginRequest());
        return "form-login"; // ten html
    }

    // Spring Validation
    // Tao 1 Object trong => truyen Object => HTML (Validate check trong ben html)
//    @PostMapping("ket-qua")
//    public String xuLyForm(@RequestParam("u1") String username,
//                           @RequestParam("p1") String pass, Model m){
//        m.addAttribute("u11",username);
//        m.addAttribute("pass1",pass);
//        return "xu-ky";
//    }
    // Model phải để ở cuối cùng
//    Spring MVC có rule: BindingResult chỉ áp dụng cho tham số ngay trước nó.
//    Chen Model vào giữa là coi như BindingResult không liên quan
//    → Spring ném MethodArgumentNotValidException.
    @PostMapping("ket-qua")
    public String xuLyForm(@Valid @ModelAttribute("login1") LoginRequest request,
                            BindingResult result,Model m) {
        // ten thuoc tinh trong doi tuong phan trung vs name trong input
//        if(request.getUsername().isEmpty()){
//            // ban loi trong
//        }
        if (result.hasErrors()) {
            return "form-login";
        }
        m.addAttribute("u11", request.getUsername());
        m.addAttribute("pass1", request.getPassword());
        return "xu-ky";
    }
}
