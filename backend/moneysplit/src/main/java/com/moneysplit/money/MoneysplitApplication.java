package com.moneysplit.money;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.GroupExpenses;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import com.moneysplit.money.Repository.GroupExpensesRepository;
import com.moneysplit.money.Repository.UserRepository;
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
    //uncomment to get an idea of how the entry looks like
//    @Bean
//    CommandLineRunner runner(ExpenseRepository expenseRepo, UserRepository userRepo, GroupExpensesRepository groupRepo){
//        return args -> {
//            Map<String, Double> map = new HashMap<>();
//            map.put("abc", 30.12);
//            User user = new User("Aman Dhiraj", "amandhiraj@live.com", map, LocalDateTime.now());
//            GroupExpenses groupExpenses = new GroupExpenses("Food", 100.0, List.of());
//
//            Expense expense = new Expense("abc", List.of(groupExpenses));
//            expenseRepo.insert(expense);
//            userRepo.insert(user);
//            groupRepo.insert(groupExpenses);
//
//        };
//    }
}
