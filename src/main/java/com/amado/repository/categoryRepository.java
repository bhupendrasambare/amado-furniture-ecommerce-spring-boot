package com.amado.repository;

import com.amado.model.categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface categoryRepository extends JpaRepository<categories,Integer> {
    @Override
    Optional<categories> findById(Integer integer);

    Optional<categories> findByNameIgnoreCase(String name);
}
