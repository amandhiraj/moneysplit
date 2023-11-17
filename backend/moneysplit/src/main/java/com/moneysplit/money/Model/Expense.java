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
    private List<GroupExpenses> groupExpenses;

    public Expense(String groupId, List<GroupExpenses> groupExpenses) {
        this.groupId = groupId;
        this.groupExpenses = groupExpenses;
    }

}
