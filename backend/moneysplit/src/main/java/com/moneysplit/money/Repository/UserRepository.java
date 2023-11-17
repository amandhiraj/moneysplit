package com.moneysplit.money.Repository;

import com.moneysplit.money.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);
    @Query("{'email': ?0}")
    User searchUserByEmail(String email);
}
