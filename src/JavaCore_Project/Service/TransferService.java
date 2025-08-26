package JavaCore_Project.Service;

import JavaCore_Project.Exceptions.InvalidAmountException;
import JavaCore_Project.Exceptions.TransferException;
import JavaCore_Project.Model.Account;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TransferService {
    private final Map<String, Account> accounts = new HashMap<>();

    public void loadAccounts(String file) throws IOException {
        accounts.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    accounts.put(parts[0], new Account(parts[0], Integer.parseInt(parts[1])));
                }
            }
        }
    }

    public void saveAccounts(String file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (Account account : accounts.values()) {
                bufferedWriter.write(account.getNumber() + ";" + account.getBalance());
                bufferedWriter.newLine();
            }
        }
    }

    public void transfer(String accountFrom, String accountTo, int amount) throws TransferException {
        if (!accounts.containsKey(accountFrom) || !accounts.containsKey(accountTo)) {
            throw new TransferException("Invalid account number.");
        }
        if (amount <= 0) {
            throw new InvalidAmountException("The amount must be positive.");
        }
        Account accFrom = accounts.get(accountFrom);
        Account accTo = accounts.get(accountTo);
        if (accFrom.getBalance() < amount) {
            throw new InvalidAmountException("Insufficient funds.");
        }
        accFrom.withdraw(amount);
        accTo.deposit(amount);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}