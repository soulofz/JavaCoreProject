package JavaCore_Project.Model;

import JavaCore_Project.Exceptions.InvalidAmountException;

public class Account {
    private final String number;
    private int balance;

    public Account(String number, int balance) {
        this.balance = balance;
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new InvalidAmountException("Сумма должна быть положительной.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
        } else {
            throw new InvalidAmountException("Невалидная сумма.");
        }
    }

    @Override
    public String toString() {
        return number + ";" + balance;
    }
}
