package com.amado.service;

import com.amado.model.ip;
import com.amado.repository.ipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ipService {
    @Autowired
    ipRepository ipRepository;

    public ip create(ip ip){
        return ipRepository.save(ip);
    }

    public List<ip> getByUser(int id){
        return ipRepository.findByUsers_Id(id);
    }

    public List<ip> getByUser(String email){
        return ipRepository.findByUsers_EmailIgnoreCase(email);
    }
}
