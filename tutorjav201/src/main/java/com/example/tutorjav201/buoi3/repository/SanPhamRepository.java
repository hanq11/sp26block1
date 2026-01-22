package com.example.tutorjav201.buoi3.repository;

import com.example.tutorjav201.buoi3.model.SanPham;
import com.example.tutorjav201.buoi3.util.HibernateConfigBuoi3;
import org.hibernate.Session;

import java.util.List;

public class SanPhamRepository {
    private Session session = null;

    public SanPhamRepository() {
        session = HibernateConfigBuoi3.getFACTORY().openSession();
    }

    public List<SanPham> getAll() {
        return session.createQuery("SELECT sp FROM SanPham sp").list();
    }

    public SanPham getById(Integer id) {
        return session.find(SanPham.class, id);
    }
}
