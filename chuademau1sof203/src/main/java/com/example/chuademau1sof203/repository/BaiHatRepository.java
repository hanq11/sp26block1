package com.example.chuademau1sof203.repository;

import com.example.chuademau1sof203.entity.BaiHat;
import com.example.chuademau1sof203.util.DbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiHatRepository {
    private Connection connection = null;

    public BaiHatRepository() {
        connection = DbConnect.getConnection();
    }

    public List<BaiHat> getAll() {
        String sql = "SELECT * FROM bai_hat";
        List<BaiHat> danhSach = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhSach.add(new BaiHat(
                        rs.getInt("id"),
                        rs.getString("ten_bai_hat"),
                        rs.getFloat("gia"),
                        rs.getBoolean("phat_hanh_dia"),
                        rs.getString("ngay_ra_mat")
                ));
            }
            return danhSach;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void addBaiHat(BaiHat baiHat) {
        String sql = "INSERT INTO bai_hat (ten_bai_hat, gia, phat_hanh_dia, ngay_ra_mat) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, baiHat.getTenBaiHat());
            ps.setFloat(2, baiHat.getGia());
            ps.setBoolean(3, baiHat.getPhatHanhDia());
            ps.setString(4, baiHat.getNgayRaMat());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBaiHat(BaiHat baiHat) {
        String sql = "UPDATE bai_hat SET ten_bai_hat = ?, gia = ?, phat_hanh_dia = ?, ngay_ra_mat = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, baiHat.getTenBaiHat());
            ps.setFloat(2, baiHat.getGia());
            ps.setBoolean(3, baiHat.getPhatHanhDia());
            ps.setString(4, baiHat.getNgayRaMat());
            ps.setInt(5, baiHat.getId());
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public BaiHat getById(Integer id) {
        String sql = "SELECT * FROM bai_hat WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new BaiHat(
                        rs.getInt("id"),
                        rs.getString("ten_bai_hat"),
                        rs.getFloat("gia"),
                        rs.getBoolean("phat_hanh_dia"),
                        rs.getString("ngay_ra_mat")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteBaiHat(Integer id) {
        String sql = "DELETE FROM bai_hat WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
