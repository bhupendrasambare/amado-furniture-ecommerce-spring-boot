package com.amado.service;

import com.amado.model.cart;
import com.amado.repository.cartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cartService {

    @Autowired
    cartRepository cartRepository;

    public cart create(cart cart){
        return cartRepository.save(cart);
    }

    public cart update(cart a){
        cart b = cartRepository.findById(a.getId()).get();
        if(b.getQuantity() != a.getQuantity()){
            b.setQuantity(a.getQuantity());
        }
        return cartRepository.save(b);
    }

    public List<cart> getAll(){
        return cartRepository.findAll();
    }

    public cart getById(int id){
        Optional<cart> data= cartRepository.findById(id);
        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    public List<cart> getByUser(String email){
        return cartRepository.findByUsers_EmailIgnoreCase(email);
    }

    public List<cart> getByUser(int id){
        return cartRepository.findByUsers_Id(id);
    }

    public void delete(int id){
        cartRepository.deleteById(id);
    }
}
