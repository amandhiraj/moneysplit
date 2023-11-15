package com.moneysplit.money.Model;

import java.util.*;

public class User {
    private Integer id;
    private String name;
    private String email;
    private double runningCost;

    public User(int id, String name, String email, double runningCost) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.runningCost = runningCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getRunningCost() {
        return runningCost;
    }

    public void setRunningCost(double runningCost) {
        this.runningCost = runningCost;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", runningCost=" + runningCost +
                '}';
    }
}
