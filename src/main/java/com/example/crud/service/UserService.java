package com.example.crud.service;

import com.example.crud.entity.UserEntity;
import com.example.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllusersList(){
        return userRepository.findAll();
    }
    public int getCoutAlluser (){
        return userRepository.findAll().size();
    }
    public  UserEntity getUserByNameAndPassword(UserEntity user){
        return userRepository.findByNameAndPassword(user.getName(),user.getPassword());
    }

    public UserEntity createUser (UserEntity user){
        return userRepository.save(user);
    }
}
