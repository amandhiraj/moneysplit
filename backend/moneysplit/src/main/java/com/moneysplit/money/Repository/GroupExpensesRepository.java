package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.GroupExpenses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupExpensesRepository extends MongoRepository<GroupExpenses, String> {
}
