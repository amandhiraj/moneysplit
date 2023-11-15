package com.moneysplit.money.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group {

    private String groupID;
    private String name;
    private Integer numPPL;
    private List<Expense> expenses;

    public Group(String groupID, String name, Integer numPPL, List<Expense> expenses) {
        this.groupID = groupID;
        this.name = name;
        this.numPPL = numPPL;
        this.expenses = expenses;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumPPL() {
        return numPPL;
    }

    public void setNumPPL(Integer numPPL) {
        this.numPPL = numPPL;
    }


    @Override
    public String toString() {
        return "Group{" +
                "groupID='" + groupID + '\'' +
                ", name='" + name + '\'' +
                ", numPPL=" + numPPL +
                '}';
    }
}
