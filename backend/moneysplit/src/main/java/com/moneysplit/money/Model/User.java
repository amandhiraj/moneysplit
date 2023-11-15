package com.moneysplit.money.Model;

public class User {
    private Integer id;
    private String name;
    private String email;

    private String groupID;
    private double netAmount;

    public User(Integer id, String name, String email, String groupID, double netAmount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.groupID = groupID;
        this.netAmount = netAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", groupID='" + groupID + '\'' +
                ", netAmount=" + netAmount +
                '}';
    }
}
