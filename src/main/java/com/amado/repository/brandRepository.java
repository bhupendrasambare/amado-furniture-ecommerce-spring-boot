package com.amado.repository;

import com.amado.model.brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface brandRepository extends JpaRepository<brand,Integer> {
    @Override
    Optional<brand> findById(Integer integer);

    Optional<brand> findByNameIgnoreCase(String name);

}
