package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.GroupExpenses;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import com.moneysplit.money.Repository.GroupExpensesRepository;
import com.moneysplit.money.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final GroupExpensesRepository groupExpensesRepository;

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping
    public List<Expense> getExpensesByGroupId(String groupId) {
        return expenseRepository.findAllExpenseByGroupId(groupId);
    }

    public ResponseEntity<?> udateExpense(String groupId, String expenseName, String email) {
        ResponseEntity<?> responseEntity = null;

        User user = userRepository.searchUserByEmail(email);
        Expense expense = expenseRepository.findExpenseByGroupId(groupId);

        for (int i = 0 ; i < expense.getGroupExpenses().size(); i++){
            if(user != null && userRepository.findUserByEmail(user.getEmail()).isPresent()){
                if (expense.getGroupExpenses().get(i).getName().equals(expenseName)){
                    if (expense.getGroupExpenses().get(i).getSharedBy().contains(user)){
                        return new ResponseEntity<>("This user is already part of the group!", HttpStatus.BAD_REQUEST);
                    }

                    expense.getGroupExpenses().get(i).getSharedBy().add(user);
                    user.getGroups().put(groupId, 0.0);
                    userRepository.save(user);
                    expenseRepository.save(expense);
                    responseEntity = new ResponseEntity<>("Added User: " + user.getName() + " to group: " + groupId, HttpStatus.OK);
                    break;
                } else {
                    responseEntity = new ResponseEntity<>("No valid group found!", HttpStatus.BAD_REQUEST);

                }
            } else {
                responseEntity = new ResponseEntity<>("User does not exist!", HttpStatus.BAD_REQUEST);


            }
        }
        return responseEntity;
    }
    @PostMapping
    public ResponseEntity<?> addExpense(String groupId, GroupExpenses groupExpenses) {
        Expense expense = expenseRepository.findExpenseByGroupId(groupId);
        expense.getGroupExpenses().add(groupExpenses);
        expenseRepository.save(expense);
        return new ResponseEntity<>("Expense Added for group: " + groupId, HttpStatus.OK);

    }
}
