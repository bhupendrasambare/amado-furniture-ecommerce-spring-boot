package com.amado.service;

import com.amado.model.images;
import com.amado.repository.imageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class imageService {
    @Autowired
    imageRepository imageRepository;

    public images create(images i){
        return imageRepository.save(i);
    }

    public List<images> getByProduct(int id){
        return imageRepository.findByProduct_Id(id);
    }

    public void delete(int id){
        imageRepository.deleteById(id);
    }
}
