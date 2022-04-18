package com.amado.repository;

import com.amado.model.images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface imageRepository extends JpaRepository<images,Integer> {
    List<images> findByProduct_Id(int id);

}
