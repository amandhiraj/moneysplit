package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
