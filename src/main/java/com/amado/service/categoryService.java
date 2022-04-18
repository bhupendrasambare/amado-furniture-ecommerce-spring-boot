package com.amado.service;

import com.amado.model.categories;
import com.amado.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryService {
    @Autowired
    categoryRepository categoryRepository;

    public categories create(categories c){
        return categoryRepository.save(c);
    }

    public categories findById(int id){
        Optional<categories> cat = categoryRepository.findById(id);
        if(cat.isPresent()){
            return cat.get();
        }
        return null;
    }

    public categories findByName(String name){
        Optional<categories> cat = categoryRepository.findByNameIgnoreCase(name);
        if(cat.isPresent()){
            return cat.get();
        }
        return null;
    }

    public int countCategories(){
        return categoryRepository.findAll().size();
    }

    public List<categories> getCategories(){
        return categoryRepository.findAll();
    }

    public void delete(int id){
        categoryRepository.deleteById(id);
    }
}
