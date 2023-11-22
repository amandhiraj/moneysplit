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
    private String groupId;
    private String name;
    private List<User> membersList;
    private List<org.bson.Document> settledTransactions;
    private double revisionVersion;

    public Expense(String groupId, String name, List<User> membersList, List<org.bson.Document> settledTransactions, double revisionVersion) {
        this.groupId = groupId;
        this.name = name;
        this.membersList = membersList;
        this.settledTransactions = settledTransactions;
        this.revisionVersion = revisionVersion;
    }
}
