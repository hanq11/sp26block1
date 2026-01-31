package com.example.sof302201sof3022.buoi10.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bac_si")
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ten khong duoc de trong")
    @Column(name = "ten_bac_si")
    private String tenBacSi;

    @NotNull(message = "tuoi khong duoc de trong")
    @Min(value = 1, message = "tuoi khong duoc nho hon 1")
    @Column(name = "tuoi")
    private Integer tuoi;

    @NotNull(message = "khong duoc de trong gioi tinh")
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @NotNull(message = "Khong duoc de trong benh vien")
    @ManyToOne
    @JoinColumn(name = "benh_vien_id", referencedColumnName = "id")
    private BenhVien benhVien;
}
