package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseService {
    @GetMapping
    public List<Expense> getExpenses() {

        List<User> users = new ArrayList<>();
        User user1 = new User(1, "aman", "amandhiraj@live.ca", "sA34Das", 10);

        users.add(user1);

        return List.of(
                new Expense(
                        "Food",
                        100.0,
                        users
                )
        );
    }

}
