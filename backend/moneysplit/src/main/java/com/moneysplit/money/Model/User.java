package com.moneysplit.money.Model;

public class User {
    private Integer id;
    private String name;
    private String email;

    private String groupID;

    public User() {
    }

    public User(String name, String email, String groupID) {
        this.name = name;
        this.email = email;
        this.groupID = groupID;
    }

    public User(Integer id, String name, String email, String groupID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.groupID = groupID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
