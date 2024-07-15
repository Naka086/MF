package com.example.MF.Service;

import com.example.MF.Entity.Center;
import com.example.MF.Entity.User;

import java.util.List;
import java.util.Optional;

public interface CenterService {
    List<Center> getAllCenters();
    Optional<Center> getCenterById(Long id);
    Center saveOrUpdateCenter(Center center);
    void deleteCenter(Long id);
}
