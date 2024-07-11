package com.example.MF.Service;

import com.example.MF.Entity.Center;
import com.example.MF.Entity.User;

public interface CenterService {
    void saveCenter(Center center);
    Iterable<Center> findCenters();
    User getCenterId(Long id);
    void deleteCenter(Long id);
}
