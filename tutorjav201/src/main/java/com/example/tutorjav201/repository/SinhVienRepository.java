package com.example.tutorjav201.repository;

import com.example.tutorjav201.model.SinhVien;
import com.example.tutorjav201.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("SELECT sv FROM SinhVien sv").list();
    }
}
