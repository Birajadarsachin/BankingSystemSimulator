package service;

import model.Account;
import exceptions.*;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    // Map to store accounts using accountNumber as key
    private Map<String, Account> accounts = new HashMap<>();

    // Create a new account
    public Account createAccount(String holderName) throws InvalidNameException {
        if (holderName == null || holderName.trim().isEmpty()) {
            throw new InvalidNameException("Account holder name cannot be empty!");
        }

        Account newAccount = new Account(holderName);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        System.out.println(" Account created successfully! Account Number: " + newAccount.getAccountNumber());
        return newAccount;
    }

    // Deposit
    public void deposit(String accNo, double amount)
            throws AccountNotFoundException, InvalidAmountException {
        Account acc = findAccount(accNo);
        acc.deposit(amount);
    }

    // Withdraw
    public void withdraw(String accNo, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Account acc = findAccount(accNo);
        acc.withdraw(amount);
    }

    // Transfer funds
    public void transfer(String fromAcc, String toAcc, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Account source = findAccount(fromAcc);
        Account target = findAccount(toAcc);

        source.withdraw(amount);
        target.deposit(amount);

        System.out.println(" Transferred ₹" + amount + " from " + fromAcc + " to " + toAcc);
    }

    // Show balance
    public void showBalance(String accNo) throws AccountNotFoundException {
        Account acc = findAccount(accNo);
        System.out.println(" Account: " + acc.getAccountNumber());
        System.out.println(" Holder: " + acc.getHolderName());
        System.out.println(" Balance: ₹" + acc.getBalance());
    }

    // Helper: find account by number
    private Account findAccount(String accNo) throws AccountNotFoundException {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            throw new AccountNotFoundException("No account found with number: " + accNo);
        }
        return acc;
    }

    // Use Stream API to search by name (bonus functional part)
    public List<Account> searchAccountsByName(String name) {
        return accounts.values().stream()
                .filter(a -> a.getHolderName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Display all accounts (optional utility)
    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println(" No accounts available yet.");
        } else {
            accounts.values().forEach(System.out::println);
        }
    }
}
