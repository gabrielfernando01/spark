package com.everis.curso.java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testDeposit() {
        Account cuenta = new Account("TestUser");
        cuenta.deposit(100.0);
        assertEquals(100.0, cuenta.getBalance(), 0.01);
        cuenta.deposit(-50.0); // Should not change
        assertEquals(100.0, cuenta.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        Account cuenta = new Account("TestUser", 200.0);
        cuenta.withdraw(150.0);
        assertEquals(50.0, cuenta.getBalance(), 0.01);
        cuenta.withdraw(100.0); // Should set to 0
        assertEquals(0.0, cuenta.getBalance(), 0.01);
    }
}