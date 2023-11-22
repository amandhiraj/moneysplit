package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.Transactions;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import com.moneysplit.money.Repository.TranscationRepository;
import com.moneysplit.money.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final TranscationRepository transRepository;
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

    public ResponseEntity<?> updateExpensesByGroupId(String groupId, Expense updatedExpense) {
        Expense existingExpense = expenseRepository.findAllExpenseByGroupId(groupId);

        double cacheVersion = existingExpense.getRevisionVersion();

        if (existingExpense.getRevisionVersion() > updatedExpense.getRevisionVersion()){
            return new ResponseEntity<>("outdated", HttpStatus.BAD_REQUEST);
        } else {
            updatedExpense.setRevisionVersion(cacheVersion + 1.0);
            expenseRepository.delete(existingExpense);
            expenseRepository.save(updatedExpense);
        }

        return new ResponseEntity<>(existingExpense, HttpStatus.OK);
    }
}
