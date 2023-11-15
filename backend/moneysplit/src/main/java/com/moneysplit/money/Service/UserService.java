package com.moneysplit.money.Service;

import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.time.ZonedDateTime;
import java.util.*;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    @GetMapping
    public List<User> getUsers() {
       return userRepository.findAll();
    }

}
