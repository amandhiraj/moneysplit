package com.moneysplit.money.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Transactions {

    private String id;
    private String text;
    private double amount;
    private List<String> sharedBy;


    public Transactions(String id, String text, double amount, List<String> sharedBy) {
        this.id = id;
        this.text = text;
        this.amount = amount;
        this.sharedBy = sharedBy;
    }
}
