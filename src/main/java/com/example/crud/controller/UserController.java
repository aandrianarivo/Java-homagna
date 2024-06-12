package com.example.crud.controller;

import com.example.crud.entity.UserEntity;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity>getAllUsers(){return userService.getAllusersList();}

    @GetMapping("/count")
    public int getCountOfUsers(){
        return userService.getCoutAlluser();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserEntity>createUser(@RequestBody UserEntity user){
        UserEntity createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
