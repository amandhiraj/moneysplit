package com.moneysplit.money.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;
@Data
@Document
public class GroupExpenses {
    private String name;
    private double amount;
    private List<User> sharedBy;

    public GroupExpenses(String name, double amount, List<User> sharedBy) {
        this.name = name;
        this.amount = amount;
        this.sharedBy = sharedBy;
    }
}
