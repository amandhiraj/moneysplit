package com.moneysplit.money;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MoneysplitApplication {
    //http://localhost:8080/api/v1/expenses/s3F34
    public String CreateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static void main(String[] args) {
        SpringApplication.run(MoneysplitApplication.class, args);
    }
    //uncomment to get an idea of how the entry looks like
//    @Bean
//    CommandLineRunner runner(ExpenseRepository expenseRepo){
//        return args -> {
//            List<User> users = new ArrayList<>();
//            User user1 = new User(CreateUUID(),"Aman", 0, new ArrayList<>());
//            User user2 = new User(CreateUUID(),"Vamsi", 0, new ArrayList<>());
//            users.add(user1);
//
//            users.add(user2);
//
//
//            Expense expense = new Expense("s3F35", "LIQ Trip", users);
//            expenseRepo.insert(expense);
//        };
//    }
}
