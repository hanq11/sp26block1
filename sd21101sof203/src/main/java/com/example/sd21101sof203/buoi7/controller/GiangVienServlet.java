package com.example.sd21101sof203.buoi7.controller;

import com.example.sd21101sof203.buoi7.entity.GiangVien;
import com.example.sd21101sof203.buoi7.repository.GiangVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "gv-servlet",
        value = {"/giang-vien/hien-thi-tat-ca",
                "/giang-vien/detail",
                "/giang-vien/remove",
                "/giang-vien/view-update",
                "/giang-vien/tim-kiem"
        })
public class GiangVienServlet extends HttpServlet {
    GiangVienRepository repo = new GiangVienRepository();
    List<GiangVien> listGVs= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listGVs = repo.getAll();//lấy dữ liệu từ repo
        req.setAttribute("listGVs",listGVs);
        req.getRequestDispatcher("/buoi7/hienthi.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
