package com.everis.curso.java;

/**
 * Represents a bank account with a holder and balance.
 * @author Grok
 */

/**
 * Business rules:
 * Create a class called Account that will have the following attributes: holder and amount (can have decimals).
 * The title will be mandatory, and the quantity is optional. Create two constructors that meet the above criteria.
 * Create your get, set and toString methods.
 *
 * You will have two special methods:
 *
 * Enter(double amount): an amount is entered into the account, if the amount entered is negative, nothing will be done.
 * Withdraw(double amount): an amount is withdrawn from the account, if the current amount is negative when subtracted from the amount transferred to us, the amount in the account becomes 0.
 */

public class Account {
    private String holder;  // Account holder's name
    private double balance; // Amount balance

    // Construct
    public Account(String holder) {
        this(holder, 0.0);   // Default balance is 0
    }

    public Account(String holder, double balance) {
        this.holder = holder != null ? holder : "Unknown";  // Avoid null titular
        this.balance = Math.max(0, balance);    // Ensure balance is non-negative
    }

    // Getters and Setters
    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder!= null? holder : "Unknown";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = Math.max(0, balance);    // Ensure non-negative balance
    }

    /**
     * Deposit money into the account if the amount is positive.
     * @param balance Amount to deposit
     */

    public void deposit(double balance) {
        if (balance > 0) {
            this.balance += balance;
        }
    }

    /**
     * Withdraw money from the account, setting balance to 0 if it would go negative.
     * @param balance Amount to withdraw
     */
    public void withdraw(double balance) {
        this.balance = Math.max(0, this.balance - balance);
    }

    /**
     * Returns a string representation of the account
     * @return String representation of the account
     */
    @Override
    public String toString() {
        return String.format("The holder account %s have %.2f dollars in the account", holder, balance);
    }
}
