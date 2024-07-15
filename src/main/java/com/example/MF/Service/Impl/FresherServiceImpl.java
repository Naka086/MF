package com.example.MF.Service.Impl;

import com.example.MF.Entity.Fresher;
import com.example.MF.Repository.FresherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FresherServiceImpl {
    @Autowired
    private FresherRepository fresherRepository;

    public List<Fresher> getAllFreshers() {
        return fresherRepository.findAll();
    }

    public Optional<Fresher> getFresherById(Long id) {
        return fresherRepository.findById(id);
    }

    public Fresher saveOrUpdateFresher(Fresher fresher) {
        return fresherRepository.save(fresher);
    }

    public void deleteFresher(Long id) {
        fresherRepository.deleteById(id);
    }
}
