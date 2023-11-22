package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.Transactions;
import com.moneysplit.money.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TranscationRepository extends MongoRepository<Transactions, String> {
    @Query("{'id': ?0 }")
    Transactions findTransactionsById(String id);
}
