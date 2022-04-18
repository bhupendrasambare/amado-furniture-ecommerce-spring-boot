package com.amado.repository;

import com.amado.model.ip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ipRepository extends JpaRepository<ip,Integer> {
    List<ip> findByUsers_EmailIgnoreCase(String email);

    List<ip> findByUsers_Id(int id);
}
