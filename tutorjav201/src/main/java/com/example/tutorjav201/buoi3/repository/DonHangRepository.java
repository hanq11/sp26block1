package com.example.tutorjav201.buoi3.repository;

import com.example.tutorjav201.buoi3.model.DonHang;
import com.example.tutorjav201.buoi3.util.HibernateConfigBuoi3;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

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

    // JPQL - jarkatar persistence query language - huong toi object
    public List<DonHang> timKiemTheoTenKhachHangJPQL(String tenKhachHang) {
        Query query = session.createQuery("SELECT dh FROM DonHang dh WHERE dh.tenKhachHang LIKE :tenKhachHang");
        query.setParameter("tenKhachHang", "%" + tenKhachHang + "%");
        return query.getResultList();
    }

    // SQL - huong toi bang
    public List<DonHang> timKiemTheoTenKhachHangSQL(String tenKhachHang) {
        Query query = session.createNativeQuery("SELECT * FROM don_hang WHERE ten_khach_hang LIKE :tenKhachHang", DonHang.class);
        query.setParameter("tenKhachHang", "%" + tenKhachHang + "%");
        return query.getResultList();
    }
}
