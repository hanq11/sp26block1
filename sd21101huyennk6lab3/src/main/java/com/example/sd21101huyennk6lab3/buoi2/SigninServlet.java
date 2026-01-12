package com.example.sd21101huyennk6lab3.buoi2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "singinServlet", value = {
        "/buoi2/show-form", // GET - hien thi form
        "/buoi2/signin"     // POST - xu ly form
})
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buoi2/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("hoTen", req.getParameter("hoTen"));

        String hoTen = req.getParameter("hoTen");
        req.setAttribute("hoTen", hoTen);

        String ngaySinh = req.getParameter("ngaySinh");
        req.setAttribute("ngaySinh", ngaySinh);

        String gioiTinh = req.getParameter("gioiTinh");
        req.setAttribute("gioiTinh", gioiTinh);

        String diaChi = req.getParameter("diaChi");
        req.setAttribute("diaChi", diaChi);

        String quocGia = req.getParameter("quocGia");
        req.setAttribute("quocGia", quocGia);

        String[] arrMonHoc = req.getParameterValues("monHoc");
        req.setAttribute("arrMonHoc", arrMonHoc);

        String[] arrSoThich = req.getParameterValues("soThich");
        req.setAttribute("arrSoThich", arrSoThich);

        req.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(req, resp);
    }
}
