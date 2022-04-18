package com.amado.repository;

import com.amado.model.cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface cartRepository extends JpaRepository<cart,Integer> {

    List<cart> findByUsers_EmailIgnoreCase(String email);

    List<cart> findByUsers_Id(int id);
}
