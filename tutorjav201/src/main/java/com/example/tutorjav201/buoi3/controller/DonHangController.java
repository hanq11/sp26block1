package com.example.tutorjav201.buoi3.controller;

import com.example.tutorjav201.buoi3.model.DonHang;
import com.example.tutorjav201.buoi3.model.SanPham;
import com.example.tutorjav201.buoi3.repository.DonHangRepository;
import com.example.tutorjav201.buoi3.repository.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "donHangController", value = {
        "/don-hang/hien-thi", // GET
        "/don-hang/view-update", // GET
        "/don-hang/xoa", // GET
        "/don-hang/them", // POST
        "/don-hang/sua", // POST
})
public class DonHangController extends HttpServlet {
    DonHangRepository donHangRepository = new DonHangRepository();
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            hienThi(req, resp);
        }
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listDonHang", donHangRepository.getAll());
        req.setAttribute("listSanPham", sanPhamRepository.getAll());
        req.getRequestDispatcher("/buoi3/hien-thi.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("them")) {
            themDonHang(req, resp);
        }
    }

    private void themDonHang(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String tenKhachHang = req.getParameter("tenKhachHang");
        String ngayMua = req.getParameter("ngayMua");
        Float tongTien = Float.valueOf(req.getParameter("tongTien"));
        Boolean daThanhToan = Boolean.valueOf(req.getParameter("daThanhToan"));

        Integer idSanPham = Integer.valueOf(req.getParameter("idSanPham"));
        SanPham sp = sanPhamRepository.getById(idSanPham);

        DonHang dh = new DonHang(null, tenKhachHang, ngayMua, tongTien, daThanhToan, sp);
        donHangRepository.addDonHang(dh);

        resp.sendRedirect("/don-hang/hien-thi");
    }
}
