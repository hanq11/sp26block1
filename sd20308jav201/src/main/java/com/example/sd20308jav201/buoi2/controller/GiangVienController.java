package com.example.sd20308jav201.buoi2.controller;

import com.example.sd20308jav201.buoi2.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "giangVienController", value = {
        "/giang-vien/hien-thi", // GET
        "/giang-vien/view-update", // GET
        "/giang-vien/xoa", // GET
        "/giang-vien/them", // POST
        "/giang-vien/sua", // POST
})
public class GiangVienController extends HttpServlet {
    GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listGiangVien", giangVienRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }
}
