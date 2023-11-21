package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Service.ExpenseService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @CrossOrigin
    @GetMapping("/{groupId}")
    public ResponseEntity<?> getExpensesByGroupId(@PathVariable String groupId) {
        return expenseService.getExpensesByGroupId(groupId);
    }

    @PostMapping("update/{groupId}")
    public ResponseEntity<?> updateExpenseByGroupId(@PathVariable String groupId, @RequestBody String payload) throws JSONException {
        JSONObject jsonExpense = new JSONObject(payload);
        Expense expenses = expenseService.updateExpensesByGroupId(groupId, jsonExpense);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}
