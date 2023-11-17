package com.moneysplit.money.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Document
public class User {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private Map<String, Double> groups;
    private LocalDateTime createdAt;

    public User(String name, String email, Map<String, Double> groups, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.groups = groups;
        this.createdAt = createdAt;
    }
}
