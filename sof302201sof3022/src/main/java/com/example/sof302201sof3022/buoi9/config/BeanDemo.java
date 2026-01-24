package com.example.sof302201sof3022.buoi9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDemo {
    @Bean("bean1")
    public GiangVien getGiangVien() {
        return new GiangVien(1, "Nguyen Van A");
    }

    @Bean("bean2")
//    @Primary
    public GiangVien getGiangVien2() {
        return new GiangVien(2, "Nguyen Van A");
    }
}
