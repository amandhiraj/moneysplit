package com.moneysplit.money.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Data
@Document
public class Expense {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private double amount;
    private List<User> sharedBy;

    public Expense(String name, double amount, List<User> sharedBy) {
        this.name = name;
        this.amount = amount;
        this.sharedBy = sharedBy;
    }
}
