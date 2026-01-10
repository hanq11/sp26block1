package com.example.sd20309jav201.buoi2.controller;

import com.example.sd20309jav201.buoi2.model.TruongHoc;
import com.example.sd20309jav201.buoi2.repository.TruongHocRepository;
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
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoa(req, resp);
        }
    }

    private void xoa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        truongHocRepository.xoaTruongHoc(id);
        resp.sendRedirect("/truong-hoc/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        TruongHoc th = truongHocRepository.getById(id);
        req.setAttribute("th", th);
        req.getRequestDispatcher("/buoi2/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi2/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            them(req, resp);
        } else if(uri.contains("sua")) {
            sua(req, resp);
        }
    }

    private void sua(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenTruong = req.getParameter("tenTruong");
        String diaChi = req.getParameter("diaChi");
        TruongHoc th = new TruongHoc(id, tenTruong, diaChi);
        truongHocRepository.suaTruongHoc(th);

        resp.sendRedirect("/truong-hoc/hien-thi");
    }

    private void them(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenTruong = req.getParameter("tenTruong");
        String diaChi = req.getParameter("diaChi");
        TruongHoc th = new TruongHoc(null, tenTruong, diaChi);
        truongHocRepository.themTruongHoc(th);

        resp.sendRedirect("/truong-hoc/hien-thi");
    }
}
