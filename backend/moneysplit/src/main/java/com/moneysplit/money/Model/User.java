package com.moneysplit.money.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private List<String> groupID;
    private double netAmount;
    private LocalDateTime createdAt;

    public User(String name, String email, List<String> groupID, double netAmount, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.groupID = groupID;
        this.netAmount = netAmount;
        this.createdAt = createdAt;
    }
}
