package com.example.chuademau1sof203.controller;

import com.example.chuademau1sof203.entity.BaiHat;
import com.example.chuademau1sof203.repository.BaiHatRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "baiHatController", value = {
        "/bai-hat/hien-thi", // GET
        "/bai-hat/view-update", // GET
        "/bai-hat/delete", // GET
        "/bai-hat/detail", // GET
        "/bai-hat/add", // POST
        "/bai-hat/update", // POST
})
public class BaiHatController extends HttpServlet {
    BaiHatRepository baiHatRepository = new BaiHatRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("delete")) {
            delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        baiHatRepository.deleteBaiHat(id);
        resp.sendRedirect("/bai-hat/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("baiHat", baiHatRepository.getById(id));
        req.getRequestDispatcher("/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listBaiHat", baiHatRepository.getAll());
        req.getRequestDispatcher("/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            addBaiHat(req, resp);
        } else if(uri.contains("update")) {
            updateBaiHat(req, resp);
        }
    }

    private void updateBaiHat(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenBaiHat = req.getParameter("tenBaiHat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Boolean phatHanhDia = Boolean.valueOf(req.getParameter("phatHanhDia"));
        String ngayRaMat = req.getParameter("ngayRaMat");

        BaiHat bh = new BaiHat(id, tenBaiHat, gia, phatHanhDia, ngayRaMat);
        baiHatRepository.updateBaiHat(bh);

        resp.sendRedirect("/bai-hat/hien-thi");
    }

    private void addBaiHat(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenBaiHat = req.getParameter("tenBa" +
                "iHat");
        Float gia = Float.valueOf(req.getParameter("gia"));
        Boolean phatHanhDia = Boolean.valueOf(req.getParameter("phatHanhDia"));
        String ngayRaMat = req.getParameter("ngayRaMat");

        BaiHat bh = new BaiHat(null, tenBaiHat, gia, phatHanhDia, ngayRaMat);
        baiHatRepository.addBaiHat(bh);

        resp.sendRedirect("/bai-hat/hien-thi");
    }
}
