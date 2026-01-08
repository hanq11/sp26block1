package com.example.sd20308jav201.buoi2.controller;

import com.example.sd20308jav201.buoi2.repository.TruongHocRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "truongHocController", value = {
        "/truong-hoc/hien-thi", // GET
        "/truong-hoc/view-update", // GET
        "/truong-hoc/xoa", // GET
        "/truong-hoc/them", // POST
        "/truong-hoc/sua", // POST
})
public class TruongHocController extends HttpServlet {
    TruongHocRepository truongHocRepository = new TruongHocRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }
}
