package com.moneysplit.money.Model;

import java.util.*;

public class Expense {
    private String name;
    private double amount;
    private List<User> sharedBy;

    public Expense(String name, double amount, List<User> sharedBy) {
        this.name = name;
        this.amount = amount;
        this.sharedBy = sharedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<User> getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(List<User> sharedBy) {
        this.sharedBy = sharedBy;
    }
}
