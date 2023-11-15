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
    public ResponseEntity<Expense> getUsers() {
        List<User> people = new ArrayList<>();

        User user1 = new User(1, "aman", "ama@gmail.com", 20);
        User user2 = new User(1, "aman", "ama@gmail.com", 20);
        User user3 = new User(1, "aman", "ama@gmail.com", 20);

        people.add(user1);
        people.add(user2);
        people.add(user3);

        Expense ex = new Expense("Food", 100.0, people);

        return new ResponseEntity<>(ex,HttpStatus.OK);
    }
}
