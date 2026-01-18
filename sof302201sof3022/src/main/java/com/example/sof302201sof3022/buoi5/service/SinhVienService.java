package com.example.sof302201sof3022.buoi5.service;

import com.example.sof302201sof3022.buoi5.model.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienService {
    private List<SinhVien> danhSach = null;

    public SinhVienService() {
        danhSach = new ArrayList<>();
        danhSach.add(new SinhVien(1, "Nam", true, 19));
        danhSach.add(new SinhVien(2, "Tram", false, 29));
        danhSach.add(new SinhVien(3, "Hung", true, 39));
    }

    public List<SinhVien> getAll() {
        return danhSach;
    }

    public SinhVien findById(Integer id) {
        for(SinhVien sv: danhSach) {
            if(sv.getId().equals(id)) {
                return sv;
            }
        }
        return null;
    }

    public void addSinhVien(SinhVien sinhVien) {
        danhSach.add(sinhVien);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        int indexCanSua = -1;
        for(int i = 0; i < danhSach.size(); i++) {
            if(danhSach.get(i).getId().equals(sinhVien.getId())) {
                indexCanSua = i;
            }
        }
        danhSach.set(indexCanSua, sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        danhSach.removeIf(sinhVien -> sinhVien.getId().equals(id));
    }
}
