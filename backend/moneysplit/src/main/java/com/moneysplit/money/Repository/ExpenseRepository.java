package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'groupId': ?0 }")
    Expense findAllExpenseByGroupId(String groupId);

    @Query("{ 'groupId' : ?0}")
    Optional<Expense> checkIfExpenseByGroupIdExist(String groupId);
}
