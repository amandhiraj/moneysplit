package com.moneysplit.money;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MoneysplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneysplitApplication.class, args);
    }
    //uncomment to get an idea of how the entry looks like
    @Bean
    CommandLineRunner runner(ExpenseRepository expenseRepo){
        return args -> {
            Expense expense = new Expense("abc", "Trip", 200.0);
            expenseRepo.insert(expense);
        };
    }
}
