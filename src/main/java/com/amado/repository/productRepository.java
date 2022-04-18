package com.amado.repository;

import com.amado.model.product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface productRepository extends JpaRepository<product,Integer> {
    List<product> findByCategories_Id(int id);

    List<product> findByBrand_Id(int id);

    List<product> findByCategories_NameIgnoreCase(String name);

    List<product> findByBrand_NameIgnoreCase(String name);

    @Override
    Optional<product> findById(Integer integer);
}
