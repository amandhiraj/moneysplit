package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getExpensesByGroupId(@PathVariable String groupId) {
        List<Expense> expenses = expenseService.getExpensesByGroupId(groupId);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
