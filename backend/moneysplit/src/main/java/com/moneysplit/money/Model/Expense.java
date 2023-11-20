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

    public Expense(String groupId, String name, List<User> membersList) {
        this.groupId = groupId;
        this.name = name;
        this.membersList = membersList;
    }
}
