package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//
//Relational Operator Replacement (ROR): Changes relational operators (<=, >, etc.) to their opposites or variants, testing boundary conditions.
//Arithmetic Operator Replacement (AOR): Replaces arithmetic operators (+, -, *, etc.) to check if computations are robust.
//Conditional Boundary Replacement (CBR): Modifies loop and conditional boundaries (e.g., low >= high to low > high) to ensure correct logic flow.
//
//Integration-Level Mutation Operators:
//
//Method Call Replacement (MCR): Replaces method calls with similar ones or variations to assess integration behavior.
//Parameter Change (PC): Alters method parameters to unexpected values to test edge cases.
//Return Value Replacement (RVR): Changes return values of methods to ensure consistent handling in larger workflows.

class CountReversePairsTest {

    // Test Case 1: Basic Functionality
    @Test
    void testBasicFunctionality() {
        int[] arr = {4, 1, 2, 3, 1};
        assertEquals(3, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 2: Empty Array
    @Test
    void testEmptyArray() {
        int[] arr = {};
        assertEquals(0, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 3: Single Element Array
    @Test
    void testSingleElement() {
        int[] arr = {1};
        assertEquals(0, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 4: All Elements Same
    @Test
    void testAllElementsSame() {
        int[] arr = {2, 2, 2, 2};
        assertEquals(0, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 5: Sorted Array in Ascending Order
    @Test
    void testSortedAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(0, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 6: Sorted Array in Descending Order
    @Test
    void testSortedDescending() {
        int[] arr = {5, 4, 3, 2, 1};
        assertEquals(4, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 7: Large Values (Edge Case)
    @Test
    void testLargeValues() {
        int[] arr = {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2};
        assertEquals(3, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 8: Array with Negative Numbers
    @Test
    void testNegativeNumbers() {
        int[] arr = {-4, -2, -1, -3};
        assertEquals(3, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 9: Mixed Positive and Negative Numbers
    @Test
    void testMixedNumbers() {
        int[] arr = {-2, 5, -1, 7, 3};
        assertEquals(2, CountReversePairs.team(arr, arr.length));
    }

    // Test Case 10: Single Pair Reverse
    @Test
    void testSingleReversePair() {
        int[] arr = {3, 1};
        assertEquals(1, CountReversePairs.team(arr, arr.length));
    }
}