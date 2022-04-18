package com.amado.repository;

import com.amado.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usersRepository extends JpaRepository<users,Integer> {
    Optional<users> findByEmailIgnoreCase(String email);

    @Override
    Optional<users> findById(Integer integer);
}
