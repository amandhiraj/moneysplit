package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'groupId': ?0 }")
    List<Expense> findAllExpenseByGroupId(String groupId);
}
