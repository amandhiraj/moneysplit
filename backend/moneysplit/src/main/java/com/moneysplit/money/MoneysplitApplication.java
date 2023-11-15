package com.moneysplit.money;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
@RestController
public class MoneysplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneysplitApplication.class, args);
    }
//    @Bean
//    CommandLineRunner runner(ExpenseRepository repository){
//        return args -> {
//            User user = new User("Aman Dhiraj", "amandhiraj@live.com", List.of("s4dAda"), 30.0, LocalDateTime.now());
//            Expense expense = new Expense("Food", 100.0, List.of(user));
//            repository.insert(expense);
//        };
//    }
}
