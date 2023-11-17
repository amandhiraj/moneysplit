package com.moneysplit.money.Service;

import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @GetMapping
    public List<User> getUsers() {
       return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addUser(User user) {
        if(!userRepository.findUserByEmail(user.getEmail()).isPresent()){
            userRepository.insert(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("User already exist", HttpStatus.BAD_REQUEST);
    }
}
