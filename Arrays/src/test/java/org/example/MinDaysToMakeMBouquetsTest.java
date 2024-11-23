package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinDaysToMakeMBouquetsTest {

    // Test Case 1: Normal case with a standard array and valid k and m values
    @Test
    public void testNormalCase() {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        assertEquals(12, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 13
        // Kills AOR: Ensures correct results for normal input values.
    }

    // Test Case 2: Testing with a single flower (edge case)
    @Test
    public void testSingleFlower() {
        int[] arr = {5};
        int k = 1;
        int m = 1;
        assertEquals(5, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 5
        // Kills Boundary Value Mutation: Tests the function's behavior with minimal input (one flower).
    }

    // Test Case 3: Testing with all flowers bloomed before the required day
    @Test
    public void testEarlyBloomingFlowers() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 2;
        int m = 2;
        assertEquals(4, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 3
        // Kills CFM: Ensures that the program handles flowers that bloom early correctly.
    }

    // Test Case 4: Impossible case (not enough flowers for m bouquets)
    @Test
    public void testImpossibleCase() {
        int[] arr = {1, 2};
        int k = 3;
        int m = 2;
        assertEquals(-1, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: -1 (not enough flowers)
        // Kills BVC: Tests if the function correctly returns -1 when it's impossible to make m bouquets.
    }

    // Test Case 5: Case with large flowers but few bouquets required
    @Test
    public void testLargeNumbers() {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int k = 2;
        int m = 2;
        assertEquals(40, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 40
        // Kills CR: Tests if the program works correctly with large flower bloom days.
    }

    // Test Case 6: Case where only a subset of flowers can be used for bouquets
    @Test
    public void testSubsetOfFlowers() {
        int[] arr = {1, 3, 5, 7, 9};
        int k = 2;
        int m = 2;
        assertEquals(7, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 7
        // Kills AOR: Tests when only a subset of flowers can form the bouquets.
    }

    // Test Case 7: Case with flowers blooming on the same day
    @Test
    public void testSameDayFlowers() {
        int[] arr = {5, 5, 5, 5, 5};
        int k = 2;
        int m = 2;
        assertEquals(5, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 5
        // Kills ROR: Ensures the function handles cases where flowers bloom on the same day.
    }

    // Test Case 8: Case with multiple possible days to make bouquets
    @Test
    public void testMultiplePossibleDays() {
        int[] arr = {3, 5, 7, 8, 2, 6};
        int k = 2;
        int m = 3;
        assertEquals(8, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 7
        // Kills PM: Verifies the program correctly identifies the earliest day for making bouquets.
    }

    // Test Case 9: Case with a large array where the solution is late
    @Test
    public void testLargeArrayLateSolution() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) arr[i] = i + 1; // Array with numbers 1 to 100000
        int k = 100;
        int m = 1000;
        assertEquals(100000, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 100000
        // Kills BVC: Tests if the program handles very large input sizes correctly.
    }

    // Test Case 10: Case where only one bouquet can be made
    @Test
    public void testOneBouquet() {
        int[] arr = {1, 3, 5};
        int k = 3;
        int m = 1;
        assertEquals(5, MinDaysToMakeMBouquets.roseGarden(arr, k, m)); // Expected result: 5
        // Kills CR: Tests if the program correctly handles situations where only one bouquet is possible.
    }
}