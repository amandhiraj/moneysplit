package com.moneysplit.money.User;

public class User {
    private Long id;
    private String name;
    private String email;
    private double runningCost;

    public User() {
    }

    public User(Long id, String name, String email, double runningCost) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.runningCost = runningCost;
    }

    public User(String name, String email, double runningCost) {
        this.name = name;
        this.email = email;
        this.runningCost = runningCost;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", runningCost=" + runningCost +
                '}';
    }
}
