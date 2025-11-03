package app;

import exceptions.AccountNotFoundException;
import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import exceptions.InvalidNameException;
import service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNameException, InvalidAmountException, AccountNotFoundException, InsufficientBalanceException {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankService();
        boolean running = true;

        System.out.println(" Welcome to Banking System Simulator");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1️.  Create Account");
            System.out.println("2️.  Deposit");
            System.out.println("3️.  Withdraw");
            System.out.println("4️.  Check Balance");
            System.out.println("5️.  View All Accounts");
            System.out.println("6.  Exit");
            System.out.print(" Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    bankService.createAccount(name);
                }
                case 2 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    bankService.deposit(accNo, amount);
                }
                case 3 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    System.out.print("Enter withdraw amount: ");
                    double amount = sc.nextDouble();
                    bankService.withdraw(accNo, amount);
                }
                case 4 -> {
                    System.out.print("Enter account number: ");
                    String accNo = sc.nextLine();
                    bankService.showBalance(accNo);
                }
                case 5 -> bankService.listAllAccounts();
                case 6 -> {
                    running = false;
                    System.out.println(" Thank you for using the Bank App!");
                }
                default -> System.out.println(" Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
