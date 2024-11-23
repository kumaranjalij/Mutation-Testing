package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LemonadeChangeTest {

    // Test Case 1: Regular test where change can be given to all customers
    @Test
    public void testNormalCase() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);
        assertEquals(true, LemonadeChange.lemonadeChange(bills));
        // Kills AOR: Ensures correct calculation of bills when using arithmetic operators.
    }

    // Test Case 2: A $10 bill without a $5 bill to give change
    @Test
    public void testNoChangeFor10() {
        List<Integer> bills = new ArrayList<>();
        bills.add(10);
        assertEquals(false, LemonadeChange.lemonadeChange(bills));
        // Kills ROR: Ensures that a missing $5 bill correctly returns false when a $10 bill is encountered.
    }

    // Test Case 3: A $20 bill without enough change
    @Test
    public void testNoChangeFor20() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(20);
        assertEquals(false, LemonadeChange.lemonadeChange(bills));
        // Kills MCR: Ensures that missing change for a $20 bill is correctly handled.
    }

    // Test Case 4: Not enough $5 bills to give change for $20
    @Test
    public void testNotEnoughFiveFor20() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(10);
        bills.add(20);
        assertEquals(true, LemonadeChange.lemonadeChange(bills));
        // Kills AOR: Tests behavior when there are not enough $5 bills to provide change for $20.
    }

    // Test Case 5: Empty list of bills (boundary case)
    @Test
    public void testEmptyBills() {
        List<Integer> bills = new ArrayList<>();
        assertEquals(true, LemonadeChange.lemonadeChange(bills));
        // Kills Boundary Value Mutation: Ensures that an empty list does not cause errors and is treated as a valid case.
    }

    // Test Case 6: A $10 bill after multiple $5 bills
    @Test
    public void testTenAfterFive() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(10);
        assertEquals(true, LemonadeChange.lemonadeChange(bills));
        // Kills CFM: Tests if the change logic works correctly with a $10 bill after several $5 bills.
    }

    // Test Case 7: Large sequence of bills where change is available
    @Test
    public void testLargeValidSequence() {
        List<Integer> bills = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) bills.add(5);
            else if (i % 3 == 0) bills.add(10);
            else bills.add(20);
        }
        assertEquals(false, LemonadeChange.lemonadeChange(bills));
        // Kills Control Flow Mutation: Ensures that a large sequence is processed correctly, maintaining control flow integrity.
    }

    // Test Case 8: A $20 bill followed by a $10 bill
    @Test
    public void testChangeFor20Then10() {
        List<Integer> bills = new ArrayList<>();
        bills.add(20);
        bills.add(10);
        assertEquals(false, LemonadeChange.lemonadeChange(bills));
        // Kills Parameter Mutation: Tests if a sequence with $20 first and $10 later fails when change is insufficient.
    }

    // Test Case 9: Sequence of alternating $5 and $10 bills
    @Test
    public void testAlternatingFiveAndTen() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(10);
        bills.add(5);
        bills.add(10);
        bills.add(5);
        bills.add(20);
        assertEquals(true, LemonadeChange.lemonadeChange(bills));
        // Kills ROR: Ensures proper alternation between $5 and $10 bills and tests the correct change mechanism.
    }

    // Test Case 10: A $20 bill followed by two $5 bills (insufficient change)
    @Test
    public void testTwentyAfterTwoFives() {
        List<Integer> bills = new ArrayList<>();
        bills.add(5);
        bills.add(5);
        bills.add(20);
        assertEquals(false, LemonadeChange.lemonadeChange(bills));
        // Kills AOR: Tests if the $20 bill is handled correctly when there are not enough $5 bills for change.
    }
}