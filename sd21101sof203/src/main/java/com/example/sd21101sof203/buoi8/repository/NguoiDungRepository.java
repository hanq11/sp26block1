package com.example.sd21101sof203.buoi8.repository;

import com.example.sd21101sof203.buoi8.entity.NguoiDung;
import com.example.sd21101sof203.buoi8.util.DBConnectBuoi8;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungRepository {
    private Connection connection = null;

    public NguoiDungRepository() {
        connection = DBConnectBuoi8.getConnection();
    }

    public List<NguoiDung> getAll() {
        String sql = "SELECT * FROM nguoi_dung";
        List<NguoiDung> danhSach = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                danhSach.add(new NguoiDung(
                        rs.getInt("id"),
                        rs.getString("ten"),
                        rs.getString("email"),
                        rs.getInt("tuoi"),
                        rs.getBoolean("dang_hoat_dong")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSach;
    }

    public void themNguoiDung(NguoiDung nguoiDung) {
        String sql = "INSERT INTO nguoi_dung (ten, email, tuoi, dang_hoat_dong) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, nguoiDung.getTen());
            ps.setString(2, nguoiDung.getEmail());
            ps.setInt(3, nguoiDung.getTuoi());
            ps.setBoolean(4, nguoiDung.getDangHoatDong());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
