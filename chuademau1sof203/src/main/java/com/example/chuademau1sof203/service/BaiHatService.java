package com.example.chuademau1sof203.service;

import com.example.chuademau1sof203.entity.BaiHatResponse;
import com.example.chuademau1sof203.repository.BaiHatRepository;

import java.util.List;

public class BaiHatService {
    BaiHatRepository baiHatRepository = new BaiHatRepository();

    public List<BaiHatResponse> getAllBaiHat() {
        return baiHatRepository.getAll();
    }
}
