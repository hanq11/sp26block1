package com.example.tutorjav201.controller;


import com.example.tutorjav201.repository.SinhVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sinhVienController", value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/xoa", // GET
        "/sinh-vien/them", // POST
        "/sinh-vien/sua", // POST
})
public class SinhVienController extends HttpServlet {
    SinhVienRepository sinhVienRepository = new SinhVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listSinhVien", sinhVienRepository.getAll());
        req.getRequestDispatcher("/buoi1/hien-thi.jsp").forward(req, resp);
    }
}
