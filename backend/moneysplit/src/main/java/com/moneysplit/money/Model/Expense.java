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
    private String groupId;
    private String name;
    private double amount;

    public Expense(String groupId, String name, double amount) {
        this.groupId = groupId;
        this.name = name;
        this.amount = amount;
    }
}
