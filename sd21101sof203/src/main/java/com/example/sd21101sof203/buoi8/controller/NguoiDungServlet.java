package com.example.sd21101sof203.buoi8.controller;

import com.example.sd21101sof203.buoi8.entity.NguoiDung;
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
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoaNguoiDung(req, resp);
        }
    }

    private void xoaNguoiDung(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        nguoiDungRepository.xoaNguoiDung(id);
        resp.sendRedirect("/nguoi-dung/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("nd", nguoiDungRepository.findById(id));
        req.getRequestDispatcher("/buoi8/view-update.jsp").forward(req,resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listNguoiDung", nguoiDungRepository.getAll());
        req.getRequestDispatcher("/buoi8/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themNguoiDung(req, resp);
        } else if(uri.contains("sua")) {
            suaNguoiDung(req, resp);
        }
    }

    private void suaNguoiDung(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String ten = req.getParameter("ten");
        String email = req.getParameter("email");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean dangHoatDong = Boolean.valueOf(req.getParameter("dangHoatDong"));

        NguoiDung nguoiDung = new NguoiDung(id, ten, email, tuoi, dangHoatDong);
        nguoiDungRepository.updateNguoiDung(nguoiDung);

        resp.sendRedirect("/nguoi-dung/hien-thi");
    }

    private void themNguoiDung(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        String email = req.getParameter("email");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean dangHoatDong = Boolean.valueOf(req.getParameter("dangHoatDong"));

        NguoiDung nguoiDung = new NguoiDung(null, ten, email, tuoi, dangHoatDong);
        nguoiDungRepository.themNguoiDung(nguoiDung);

        resp.sendRedirect("/nguoi-dung/hien-thi");
    }
}
