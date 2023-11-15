package com.moneysplit.money.User;

import java.util.*;

public class User {
    private Long id;
    private String name;
    private String email;
    private double runningCost;

    private List<Group> userGroup;

    public User() {
    }

    public User(Long id, String name, String email, double runningCost, List<Group> userGroup) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.runningCost = runningCost;
        this.userGroup = userGroup;
    }

    public User(String name, String email, double runningCost, List<Group> userGroup) {
        this.name = name;
        this.email = email;
        this.runningCost = runningCost;
        this.userGroup = userGroup;
    }

    public List<Group> getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(List<Group> userGroup) {
        this.userGroup = userGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                ", userGroup=" + userGroup +
                '}';
    }
}
