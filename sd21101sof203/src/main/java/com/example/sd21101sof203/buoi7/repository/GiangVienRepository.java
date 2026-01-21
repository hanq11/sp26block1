package com.example.sd21101sof203.buoi7.repository;

import com.example.sd21101sof203.buoi7.entity.GiangVien;
import com.example.sd21101sof203.buoi7.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {
    //tầng repo -> trao đổi trực tiếp với CSDL
    public List<GiangVien> getAll(){
        String sql = "SELECT [id]\n" +
                "      ,[ma]\n" +
                "      ,[ten]\n" +
                "      ,[tuoi]\n" +
                "      ,[gioi_tinh]\n" +
                "      ,[que_quan]\n" +
                "  FROM [dbo].[giang_vien]";
        List<GiangVien> listGVs= new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                GiangVien gv= new GiangVien();
                gv.setId(rs.getInt(1));
                gv.setMa(rs.getString(2));
                gv.setTen(rs.getString(3));
                gv.setTuoi(rs.getInt(4));
                gv.setGioiTinh(rs.getBoolean(5));
                gv.setQueQuan(rs.getString(6));
                listGVs.add(gv);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return listGVs;
    }

    public static void main(String[] args) {
        List<GiangVien> listGVs = new GiangVienRepository().getAll();
        for (GiangVien gv : listGVs) {
            System.out.println(gv.toString());
        }
    }
}
