package com.moneysplit.money;

import com.moneysplit.money.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class MoneysplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneysplitApplication.class, args);
    }

    @GetMapping
    public List<User> hello() {
        return List.of(
                new User(
                        1L,
                        "Aman",
                        "amandhiraj@gmail.com",
                        20.2
                )
        );
    }
}
