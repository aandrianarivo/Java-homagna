package com.example.crud.repository;

import com.example.crud.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByNameAndPassword(String name,String password);
}
