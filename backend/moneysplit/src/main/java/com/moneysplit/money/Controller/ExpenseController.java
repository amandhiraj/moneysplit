package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.GroupExpenses;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.UserRepository;
import com.moneysplit.money.Service.ExpenseService;
import com.moneysplit.money.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserService userService;
    @Autowired
    public ExpenseController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<?> getExpensesByGroupId(@PathVariable String groupId) {
        List<Expense> expenses = expenseService.getExpensesByGroupId(groupId);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping("/join/expense/{groupId}")
    public ResponseEntity<?> addUserToExpensesByGroupId(@PathVariable String groupId, @RequestParam String expenseName, @RequestParam String email) {
        return expenseService.udateExpense(groupId, expenseName, email);

    }
    @PostMapping("/add/{groupId}")
    public ResponseEntity<?> addExpenseByGroupId(@PathVariable String groupId, @RequestBody GroupExpenses groupExpenses) {
        return expenseService.addExpense(groupId, groupExpenses);
    }
}
