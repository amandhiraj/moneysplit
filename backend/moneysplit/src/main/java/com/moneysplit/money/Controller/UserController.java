package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.Group;
import com.moneysplit.money.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    @GetMapping
    public ResponseEntity<Group> getUsers() {

        //make a user object
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Aman", "ama@gmail.com");
        User user2 = new User(1, "Vamsi", "vamsi@gmail.com");
        User user3 = new User(1, "Pranav", "pranav@gmail.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        //make an expense object

        List<Expense> expense = new ArrayList<>();

        Expense expense1 = new Expense("Food", 100.0, users);
        Expense expense2 = new Expense("Liqs", 100.0, users);

        expense.add(expense1);
        expense.add(expense2);

        //make a group object
        List<Group> group = new ArrayList<>();
        Group group1 = new Group("2sa5D", "DR TRIP", 4, expense);

        group.add(group1);

        return new ResponseEntity<>(group1 , HttpStatus.OK);
    }
}
