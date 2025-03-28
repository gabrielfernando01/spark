package com.everis.curso.java;

public class AccountApp {
    public static void main(String[] args) {
        Account account1 = new Account("SolidDiskRoer");
        Account account2 = new Account("John Doe, 300.0");

        // Perform transaction
        account1.deposit(300.0);
        account2.deposit(400.0);
        account1.withdraw(500.0);
        account2.withdraw(100.0);

        // Display account balance
        System.out.println("Account 1: " + account1);   // "The SolidDIsk holder have 0.00 dollars in his account"
        System.out.println("Account 2: " + account2);   // "The John Doe holder have 600.00 dollars in his account"
    }
}
