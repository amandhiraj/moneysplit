package com.moneysplit.money.Controller;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Service.ExpenseService;
import com.moneysplit.money.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping(path = "api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }
}
