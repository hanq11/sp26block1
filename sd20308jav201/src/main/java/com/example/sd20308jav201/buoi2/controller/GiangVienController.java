package com.example.sd20308jav201.buoi2.controller;

import com.example.sd20308jav201.buoi2.model.GiangVien;
import com.example.sd20308jav201.buoi2.model.TruongHoc;
import com.example.sd20308jav201.buoi2.repository.GiangVienRepository;
import com.example.sd20308jav201.buoi2.repository.TruongHocRepository;
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
        "/giang-vien/tim-kiem", // GET
        "/giang-vien/phan-trang", // GET
})
public class GiangVienController extends HttpServlet {
    GiangVienRepository giangVienRepository = new GiangVienRepository();
    TruongHocRepository truongHocRepository = new TruongHocRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        } else if(uri.contains("view-update")) {
            viewUpdate(req, resp);
        } else if(uri.contains("xoa")) {
            xoaGiangVien(req, resp);
        } else if(uri.contains("tim-kiem")) {
            timKiem(req, resp);
        } else if(uri.contains("phan-trang")) {
            phanTrang(req, resp);
        }
    }

    private void phanTrang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 0;
        int size = 3;
        if (req.getParameter("page") != null) {
            page = Integer.valueOf(req.getParameter("page"));
        }
        req.setAttribute("page", page);
        int totalRows = giangVienRepository.getAll().size();
        double totalPages = Math.ceil((double) totalRows / size);
        req.setAttribute("totalPages", (int) totalPages);

        req.setAttribute("listGiangVien", giangVienRepository.phanTrang(page, size));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    private void timKiem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        req.setAttribute("listGiangVien", giangVienRepository.searchByTen(ten));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    private void xoaGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        giangVienRepository.xoaGiangVien(id);
        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void viewUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("gv", giangVienRepository.getById(id));
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/view-update.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listGiangVien", giangVienRepository.getAll());
        req.setAttribute("listTruongHoc", truongHocRepository.getAll());
        req.getRequestDispatcher("/buoi4/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themGiangVien(req, resp);
        } else if(uri.contains("sua")) {
            suaGiangVien(req, resp);
        }
    }

    private void suaGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idTruongHoc = Integer.valueOf(req.getParameter("idTruongHoc"));
        TruongHoc truongHoc = truongHocRepository.getById(idTruongHoc);

        GiangVien giangVienMoi = new GiangVien(id, tenGiangVien, tuoi, gioiTinh, truongHoc);
        giangVienRepository.suaGiangVien(giangVienMoi);

        resp.sendRedirect("/giang-vien/hien-thi");
    }

    private void themGiangVien(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenGiangVien = req.getParameter("tenGiangVien");
        Integer tuoi = Integer.valueOf(req.getParameter("tuoi"));
        Boolean gioiTinh = Boolean.valueOf(req.getParameter("gioiTinh"));

        Integer idTruongHoc = Integer.valueOf(req.getParameter("idTruongHoc"));
        TruongHoc truongHoc = truongHocRepository.getById(idTruongHoc);

        GiangVien giangVienMoi = new GiangVien(null, tenGiangVien, tuoi, gioiTinh, truongHoc);
        giangVienRepository.themGiangVien(giangVienMoi);

        resp.sendRedirect("/giang-vien/hien-thi");
    }
}
