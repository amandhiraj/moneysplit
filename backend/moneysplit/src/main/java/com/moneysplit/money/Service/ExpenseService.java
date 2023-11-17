package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public List<Expense> getExpensesByGroupId(String groupId) {
        return expenseRepository.findAllExpenseByGroupId(groupId);
    }
}
