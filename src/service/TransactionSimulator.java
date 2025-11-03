package service;

import exceptions.InvalidAmountException;
import model.Account;

public class TransactionSimulator {
    public static void main(String[] args) {
        Account acc = new Account("Sachin");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    acc.deposit(1000);
                } catch (InvalidAmountException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    acc.withdraw(500);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + acc.getBalance());
    }
}
