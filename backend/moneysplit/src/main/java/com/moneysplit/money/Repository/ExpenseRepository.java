package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.GroupExpenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'groupId': ?0 }")
    List<Expense> findAllExpenseByGroupId(String groupId);

    @Query("{'groupId': ?0 }")
    Expense findExpenseByGroupId(String groupId);

    @Query("{'groupExpenses.name': 'Food'}")
    Expense findByGroupExpenseName(String name);
}
