package com.example.tutorjav201.buoi3.repository;

import com.example.tutorjav201.buoi3.model.DonHang;
import com.example.tutorjav201.buoi3.util.HibernateConfigBuoi3;
import org.hibernate.Session;

import java.util.List;

public class DonHangRepository {
    private Session session = null;

    public DonHangRepository() {
        session = HibernateConfigBuoi3.getFACTORY().openSession();
    }

    public List<DonHang> getAll() {
        return session.createQuery("SELECT dh FROM DonHang dh").list();
    }

    public DonHang getById(Integer id) {
        return session.find(DonHang.class, id);
    }

    public void addDonHang(DonHang donHang) {
        try {
            session.getTransaction().begin();
            session.save(donHang);
            session.getTransaction().commit();;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void updateDonHang(DonHang donHang) {
        try {
            session.getTransaction().begin();
            session.merge(donHang);
            session.getTransaction().commit();;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteDonHang(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getById(id));
            session.getTransaction().commit();;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
