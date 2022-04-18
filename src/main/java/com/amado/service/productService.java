package com.amado.service;

import com.amado.model.product;
import com.amado.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    productRepository productRepository;

    public product create(product p){
        return productRepository.save(p);
    }

    public product update(product a){
        product b = productRepository.findById(a.getId()).get();
        if(a.getCategories() != b.getCategories()){
            b.setCategories(a.getCategories());
        }
        if(a.getBrand() != b.getBrand()){
            b.setBrand(a.getBrand());
        }
        if(a.getDiscription() != b.getDiscription()){
            b.setDiscription(a.getDiscription());
        }
        if(a.getName() != b.getName()){
            b.setName(a.getName());
        }
        if(a.getPrice() != b.getPrice()){
            b.setPrice(a.getPrice());
        }
        if(a.getQuantity() != b.getQuantity()){
            b.setQuantity(a.getQuantity());
        }
        if(a.getImage() != b.getImage() && a.getImage() != ""){
            b.setImage(a.getImage());
        }
        return productRepository.save(b);
    }

    public List<product> getAll(){
        return productRepository.findAll();
    }

    public product findById(int id){
        Optional<product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public  List<product> findByCategories(int id){
        return productRepository.findByCategories_Id(id);
    }

    public  List<product> findByCategories(String name){
        return productRepository.findByCategories_NameIgnoreCase(name);
    }


    public  List<product> findByBrand(int id){
        return productRepository.findByBrand_Id(id);
    }

    public  List<product> findByBrand(String name){
        return productRepository.findByBrand_NameIgnoreCase(name);
    }


    public void delete(int id){
        productRepository.deleteById(id);
    }

}
