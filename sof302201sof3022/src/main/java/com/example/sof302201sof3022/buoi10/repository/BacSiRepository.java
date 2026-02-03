package com.example.sof302201sof3022.buoi10.repository;

import com.example.sof302201sof3022.buoi10.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
    public List<BacSi> findBacSisByTenBacSiContains(String tenBacSi);

    // JPQL
    @Query("SELECT bs FROM BacSi bs WHERE bs.tuoi BETWEEN :min AND :max")
    public List<BacSi> timKiemBacSiTheoTuoiJPQL(@Param("min") Integer min, @Param("max") Integer max);


    // SQL
    @Query(value = "SELECT * FROM bac_si WHERE tuoi BETWEEN :min AND :max", nativeQuery = true)
    public List<BacSi> timKiemBacSiTheoTuoiSQL(@Param("min") Integer min, @Param("max") Integer max);
}
