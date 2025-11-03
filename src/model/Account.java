package model;

import exceptions.InvalidAmountException;
import exceptions.InsufficientBalanceException;

import java.util.Random;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public Account(String holderName) {
        this.holderName = holderName;
        this.accountNumber = generateAccountNumber(holderName);
        this.balance = 0.0;
    }

    // Generate unique account number
    private String generateAccountNumber(String name) {
        String initials = name.trim().substring(0, Math.min(2, name.length())).toUpperCase();
        int randomDigits = new Random().nextInt(9000) + 1000; // 1000–9999
        return initials + randomDigits;
    }

    // Deposit funds
    public synchronized void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println(" Deposited ₹" + amount + " into " + accountNumber);
    }

    // Withdraw funds
    public synchronized void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient funds in account " + accountNumber);
        }
        balance -= amount;
        System.out.println(" Withdrew ₹" + amount + " from " + accountNumber);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
