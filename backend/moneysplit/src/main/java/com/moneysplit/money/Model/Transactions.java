package com.moneysplit.money.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Transactions {

    private String id;
    private String itemName;
    private double amount;
    private List<User> sharedBy;


    public Transactions(String id, String itemName, double amount, List<User> sharedBy) {
        this.id = id;
        this.itemName = itemName;
        this.amount = amount;
        this.sharedBy = sharedBy;
    }
}
