package com.amado.service;

import com.amado.model.brand;
import com.amado.repository.brandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class brandService {

    @Autowired
    brandRepository brandRepository;

    public brand create( brand b){
        return brandRepository.save(b);
    }

    public brand findById(int id){
        Optional <brand> b = brandRepository.findById(id);
        if(b.isPresent()){
            return b.get();
        }
        return null;
    }

    public brand findByName(String name){
        Optional<brand> b = brandRepository.findByNameIgnoreCase(name);
        if(b.isPresent()){
            return b.get();
        }
        return null;
    }

    public List<brand> findAll(){
        return brandRepository.findAll();
    }

}
