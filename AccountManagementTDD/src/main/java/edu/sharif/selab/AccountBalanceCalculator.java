package edu.sharif.selab;

import java.util.ArrayList;
import java.util.List;

public class AccountBalanceCalculator {

    private static List<Transaction> transactionHistory = new ArrayList<>();

    // Method to calculate balance based on transactions
    public static int calculateBalance(List<Transaction> transactions) {
        clearTransactionHistory();                  // We only keep latest transactions
        int balance = 0;
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                balance += t.getAmount();
                transactionHistory.add(t);          // Store latest transactions
            } else if (t.getType() == TransactionType.WITHDRAWAL) {
                if (t.getAmount() < balance) {      // If withdrawal amount is more than balance, we refuse to do it. (It is not clear what exactly should we do, so I assume we can execute next transactions)
                    balance -= t.getAmount();
                    transactionHistory.add(t);      // Store latest transactions
                }
            }
        }
        return balance;
    }

    // Method to get the transaction history
    public static List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy to prevent external modification
    }

    // Method to add a transaction to the history
    public static void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    // Method to clear the transaction history
    public static void clearTransactionHistory() {
        transactionHistory.clear();
    }
}
