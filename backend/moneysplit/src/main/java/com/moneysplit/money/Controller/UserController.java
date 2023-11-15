package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Group;
import com.moneysplit.money.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @GetMapping
    public List<User> getUsers() {

        return List.of(
                new User(
                        1L,
                        "Aman",
                        "amandhiraj@gmail.com",
                        20.2,
                        List.of(
                                new Group(
                                        "1aAfSDSaa",
                                        "DR",
                                        4,
                                        null
                                )

                        )

                )
        );
    }
}
