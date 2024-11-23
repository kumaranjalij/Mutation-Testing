package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipPackagesDdaysTest {

    @Test
        // Test Case 1: Standard Test Case
    void testStandardCase() {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int expected = 9; // Minimum capacity needed
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

    @Test
        // Test Case 2: Edge case with one package
    void testSinglePackage() {
        int[] weights = {5};
        int d = 1;
        int expected = 5; // Only one package, so capacity is the weight of the package
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 5
    }

    @Test
        // Test Case 3: All packages with equal weight
    void testEqualWeightPackages() {
        int[] weights = {3, 3, 3, 3, 3, 3};
        int d = 2;
        int expected = 9; // Total weight per day should be divided between 2 days
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 9
    }

    @Test
        // Test Case 4: Binary Search boundary check (low = high)
    void testBinarySearchLowEqualsHigh() {
        int[] weights = {5, 3, 2, 4, 1};
        int d = 3;
        int expected = 5; // The minimum ship capacity to ship in 3 days
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

    @Test
        // Test Case 5: Edge case with max number of days
    void testMaxDays() {
        int[] weights = {2, 3, 4, 5};
        int d = 5;
        int expected = 5; // Each day carries one package, so minimum capacity is 5 (the largest package)
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 5
    }

    @Test
        // Test Case 6: Edge case where the ship capacity is max
    void testMaxShipCapacity() {
        int[] weights = {10, 20, 30, 40, 50};
        int d = 1;
        int expected = 150; // All packages must fit in one day
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 150
    }

    @Test
        // Test Case 7: Arithmetic Operator Replacement Mutation
    void testAORMutation() {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int expected = 9; // No change expected after mutation
        // Changing `+` to `-` in the `findDays` method will break the logic.
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

    @Test
        // Test Case 8: Relational Operator Replacement Mutation
    void testRORMutation() {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int expected = 9; // No change expected after mutation
        // Changing `<=` to `<` in the `findDays` method would give incorrect results.
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

    @Test
        // Test Case 9: Constant Replacement Mutation
    void testCRMutation() {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int expected = 9; // No change expected after mutation
        // Changing constants in the binary search range will affect the calculations.
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

    @Test
        // Test Case 10: Control Flow Mutation (Loop)
    void testCFMMutation() {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int expected = 9; // No change expected after mutation
        // Changing the loop condition in `findDays` (e.g., changing the comparison of `load + weights[i] > cap`) will break the logic.
        assertEquals(expected, ShipPackagesDdays.leastWeightCapacity(weights, d));  // Expected output: 8
    }

}