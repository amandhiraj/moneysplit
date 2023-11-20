package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.Transactions;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<?> getExpensesByGroupId(String groupId) {
        if (expenseRepository.checkIfExpenseByGroupIdExist(groupId).isPresent()){
            Expense expense = expenseRepository.findAllExpenseByGroupId(groupId);
            return new ResponseEntity<>(expense, HttpStatus.OK);
        }
        return new ResponseEntity<>("Error not found", HttpStatus.BAD_REQUEST);
    }

    public Expense updateExpensesByGroupId(String groupId, JSONObject payload) throws JSONException {
        return null;
    }
}
