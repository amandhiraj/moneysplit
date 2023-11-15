package com.moneysplit.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class MoneysplitApplication {
    public static void main(String[] args) {
        SpringApplication.run(MoneysplitApplication.class, args);
    }

}
