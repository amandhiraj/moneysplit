package com.moneysplit.money.Service;

import com.moneysplit.money.Model.Expense;
import com.moneysplit.money.Model.Transactions;
import com.moneysplit.money.Model.User;
import com.moneysplit.money.Repository.ExpenseRepository;
import com.moneysplit.money.Repository.TranscationRepository;
import com.moneysplit.money.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@AllArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final TranscationRepository transRepository;
    @GetMapping
    public List<Expense> getExpenses() {
        return expenseRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<?> getExpensesByGroupId(String groupId) {
        if (expenseRepository.checkIfExpenseByGroupIdExist(groupId).isPresent()){
            Expense expense = expenseRepository.findAllExpenseByGroupId(groupId);
            return new ResponseEntity<>(expense, HttpStatus.OK);
        }
        return new ResponseEntity<>("Error not found", HttpStatus.BAD_REQUEST);
    }

    public void simplifyDebts(Expense updatedExpense){
        //System.out.println("hitting");
        Expense ex = expenseRepository.findAllExpenseByGroupId(updatedExpense.getGroupId());
        Map<String, Double> netBalances = new HashMap<>();
        // Calculate net balance for each person
        for (User user : ex.getMembersList()) {
            for (Transactions transaction : user.getTransactions()) {
                String giver = user.getId();
                for (String sharedBy : transaction.getSharedBy()) {
                    String debtor = sharedBy;
                    double amount = transaction.getAmount() / transaction.getSharedBy().size();

                    netBalances.put(giver, netBalances.getOrDefault(giver, 0.0) - amount);
                    netBalances.put(debtor, netBalances.getOrDefault(debtor, 0.0) + amount);
                }
            }
        }
        List<Map.Entry<Map.Entry<String, String>, Double>> simplifiedTransactions = new ArrayList<>();

        while (true) {
            String maxCreditor = null;
            String maxDebtor = null;

            for (Map.Entry<String, Double> entry : netBalances.entrySet()) {
                if (maxCreditor == null || entry.getValue() > netBalances.get(maxCreditor)) {
                    maxCreditor = entry.getKey();
                }
                if (maxDebtor == null || entry.getValue() < netBalances.get(maxDebtor)) {
                    maxDebtor = entry.getKey();
                }
            }

            if (netBalances.getOrDefault(maxCreditor, 0.0) == 0 && netBalances.getOrDefault(maxDebtor, 0.0) == 0) {
                break;
            }

            double amount = Math.min(-netBalances.getOrDefault(maxDebtor, 0.0), netBalances.getOrDefault(maxCreditor, 0.0));

            // Simplified transaction found
            simplifiedTransactions.add(Map.entry(Map.entry(maxDebtor, maxCreditor), amount));

            // Update net balances
            netBalances.put(maxDebtor, netBalances.getOrDefault(maxDebtor, 0.0) + amount);
            netBalances.put(maxCreditor, netBalances.getOrDefault(maxCreditor, 0.0) - amount);
        }

        List<Document> documents = new ArrayList<>();
        for (Map.Entry<Map.Entry<String, String>, Double> entry : simplifiedTransactions) {
            Document transactionDoc = new Document();
            transactionDoc.append("receiver", userRepository.findUserById(entry.getKey().getKey()).getName())
                    .append("giver", userRepository.findUserById(entry.getKey().getValue()).getName())
                    .append("value", entry.getValue());
            documents.add(transactionDoc);
        }

        ex.setSettledTransactions(documents);
        expenseRepository.save(ex);
        for (Map.Entry<Map.Entry<String, String>, Double> transaction : simplifiedTransactions) {
            System.out.println("(" + transaction.getKey().getKey() + ", " + transaction.getKey().getValue() + ") Amount: "
                    + transaction.getValue());
        }
    };

    public ResponseEntity<?> updateExpensesByGroupId(String groupId, Expense updatedExpense) {
        Expense existingExpense = expenseRepository.findAllExpenseByGroupId(groupId);

        double cacheVersion = existingExpense.getRevisionVersion();

        if (existingExpense.getRevisionVersion() > updatedExpense.getRevisionVersion()){
            return new ResponseEntity<>("outdated", HttpStatus.BAD_REQUEST);
        } else {
            updatedExpense.setRevisionVersion(cacheVersion + 1.0);
            expenseRepository.delete(existingExpense);
            expenseRepository.save(updatedExpense);
            simplifyDebts(updatedExpense);
        }

        return new ResponseEntity<>(existingExpense, HttpStatus.OK);
    }
}
