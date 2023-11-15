package com.moneysplit.money.Service;

import com.moneysplit.money.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class UserService {
    @GetMapping
    public List<User> getUsers() {

        return List.of(
                new User(
                        1,
                        "Aman",
                        "Amandhiraj@live.ca",
                        "sA34Das"
                )
        );
    }

}
