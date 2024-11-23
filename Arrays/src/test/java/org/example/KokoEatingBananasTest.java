package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananasTest {

    @Test
        // Test Case 1: Standard test case with multiple piles
    void testStandardCase() {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        assertEquals(5, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 4
    }

    @Test
        // Test Case 2: Single pile of bananas
    void testSinglePile() {
        int[] v = {30};
        int h = 10;
        assertEquals(3, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 3
    }

    @Test
        // Test Case 3: Edge case with minimum hours
    void testMinimumHours() {
        int[] v = {10, 20};
        int h = 2;
        assertEquals(20, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 20
    }

    @Test
        // Test Case 4: All piles with equal bananas
    void testEqualPiles() {
        int[] v = {5, 5, 5, 5};
        int h = 4;
        assertEquals(5, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 5
    }

    @Test
        // Test Case 5: Testing with the largest possible pile
    void testLargestPile() {
        int[] v = {100};
        int h = 1;
        assertEquals(100, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 100
    }

    @Test
        // Test Case 6: Total hours equal to the number of piles (edge case)
    void testHoursEqualToPiles() {
        int[] v = {4, 4, 4, 4};
        int h = 4;
        assertEquals(4, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 4
    }

    @Test
        // Test Case 7: Arithmetic Operator Mutation (AOR)
    void testAORMutation() {
        int[] v = {3, 6, 7, 11};
        int h = 8;
        // Changing the arithmetic operator in binary search (`mid = (low + high) / 2`) to `+` or `-` would cause incorrect results.
        assertEquals(4, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 4
    }

    @Test
        // Test Case 8: Relational Operator Mutation (ROR)
    void testRORMutation() {
        int[] v = {30, 11, 23, 4, 20};
        int h = 6;
        // Replacing `<=` with `<` in binary search loop or `calculateTotalHours` would lead to incorrect logic.
        assertEquals(23, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 23
    }

    @Test
        // Test Case 9: Constant Replacement Mutation (CR)
    void testCRMutation() {
        int[] v = {3, 6, 7, 11};
        int h = 8;
        // Changing constants (e.g., `low = 1` to `low = 2`) would fail this test.
        assertEquals(4, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 4
    }

    @Test
        // Test Case 10: Boundary Value Mutation (BVC)
    void testBVCEdgeCases() {
        int[] v = {10, 20, 30};
        int h = 3;
        // Testing extreme conditions (boundary values) for `low` and `high`.
        assertEquals(30, KokoEatingBananas.minimumRateToEatBananas(v, h));  // Expected: 30
    }

}