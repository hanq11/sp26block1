package com.example.sd21101sof203.buoi8.controller;

import com.example.sd21101sof203.buoi8.repository.NguoiDungRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "nguoiDungServlet", value = {
        "/nguoi-dung/hien-thi", // GET
        "/nguoi-dung/view-update", // GET
        "/nguoi-dung/xoa", // GET
        "/nguoi-dung/them", // POST
        "/nguoi-dung/sua", // POST
})
public class NguoiDungServlet extends HttpServlet {
    NguoiDungRepository nguoiDungRepository = new NguoiDungRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNguoiDung", nguoiDungRepository.getAll());
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }
}
