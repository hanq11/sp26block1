package com.poly.demo.B5_CRUD_List_Fix_Cung.service;

import com.poly.demo.B5_CRUD_List_Fix_Cung.enttiy.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienService {
    // Co che Bean trong Spring boot => danh dau theo tang annotation
    // static
    // khoi tao contructor
    private List<SinhVien>lists = new ArrayList<>();

    public SinhVienService (){
        // Them phan tu trong contructor
        lists.add(new SinhVien("SV01","Nguyen Van A",10,"Ha noi",true));
        lists.add(new SinhVien("SV02","Nguyen Van A1",15,"Ha noi",false));
        lists.add(new SinhVien("SV03","Nguyen Van A1",10,"Ha gfsgnoi",false));
        lists.add(new SinhVien("SV04","Nguyen Van 1A",10,"gsf noi",true));
        lists.add(new SinhVien("SV05","Nguyen Van Afds",10,"Ha noi",true));
    }

    public List<SinhVien> getLists() {
        return lists;
    }

    public void addSinhVien(SinhVien sinhVien) {
        lists.add(sinhVien);
    }
}
