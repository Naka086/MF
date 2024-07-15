package com.example.MF.Service.Impl;

import com.example.MF.Entity.Center;
import com.example.MF.Repository.CenterRepository;
import com.example.MF.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    private CenterRepository centerRepository;

    @Override
    public List<Center> getAllCenters() {
        return centerRepository.findAll();
    }

    @Override
    public Optional<Center> getCenterById(Long id) {
        return centerRepository.findById(id);
    }

    @Override
    public Center saveOrUpdateCenter(Center center) {
        return centerRepository.save(center);
    }

    @Override
    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);
    }
}
