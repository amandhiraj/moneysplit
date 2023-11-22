package com.moneysplit.money.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String name;
    private double balance;
    private List<Transactions> transactions;

    public User(String name, double balance, List<Transactions> transactions) {
        this.name = name;
        this.balance = balance;
        this.transactions = transactions;
    }
}
