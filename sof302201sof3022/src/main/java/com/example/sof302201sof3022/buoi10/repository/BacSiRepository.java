package com.example.sof302201sof3022.buoi10.repository;

import com.example.sof302201sof3022.buoi10.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
}
