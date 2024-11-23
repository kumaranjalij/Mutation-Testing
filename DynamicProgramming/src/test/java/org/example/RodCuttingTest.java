package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RodCuttingTest {

    // Test Case 1: Basic Test
    @Test
    public void testBasicCase() {
        int wt[] = {2, 4, 6};
        int val[] = {5, 11, 13};
        int W = 10;
        assertEquals(27, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills arithmetic mutation (AOR)
    }

    // Test Case 2: Single Item Fits Exactly
    @Test
    public void testSingleItemFits() {
        int wt[] = {3};
        int val[] = {10};
        int W = 6;
        assertEquals(20, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills relational mutation (ROR)
    }

    // Test Case 3: Capacity Zero
    @Test
    public void testCapacityZero() {
        int wt[] = {2, 4};
        int val[] = {5, 10};
        int W = 0;
        assertEquals(0, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills control flow mutation
    }

    // Test Case 4: Large Capacity
    @Test
    public void testLargeCapacity() {
        int wt[] = {2, 5};
        int val[] = {10, 20};
        int W = 100;
        assertEquals(500, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills boundary value mutation
    }

    // Test Case 5: All Items Have Same Weight
    @Test
    public void testSameWeightDifferentValues() {
        int wt[] = {3, 3, 3};
        int val[] = {5, 10, 15};
        int W = 9;
        assertEquals(45, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills logical connector mutation (LCR)
    }

    // Test Case 6: Single Item Greater Than Capacity
    @Test
    public void testSingleItemTooLarge() {
        int wt[] = {5};
        int val[] = {20};
        int W = 4;
        assertEquals(0, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills arithmetic mutation (AOR)
    }

    // Test Case 7: Multiple Items, No Fit
    @Test
    public void testMultipleItemsNoFit() {
        int wt[] = {7, 8, 9};
        int val[] = {10, 15, 20};
        int W = 6;
        assertEquals(0, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills input parameter mutation
    }

    // Test Case 8: Items with Zero Value
    @Test
    public void testItemsWithZeroValue() {
        int wt[] = {1, 2};
        int val[] = {0, 0};
        int W = 5;
        assertEquals(0, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills boundary value mutation
    }

    // Test Case 9: Mixed Positive and Large Weights
    @Test
    public void testMixedWeights() {
        int wt[] = {1, 10, 20};
        int val[] = {30, 100, 200};
        int W = 10;
        assertEquals(300, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills input parameter mutation
    }

    // Test Case 10: Minimal Weight and High Value
    @Test
    public void testMinimalWeightHighValue() {
        int wt[] = {1};
        int val[] = {1000};
        int W = 5;
        assertEquals(5000, RodCutting.unboundedKnapsack(wt.length, W, val, wt)); // Kills control flow mutation
    }
}