package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainwaterTest {
    @Test
        // Test Case 1: Standard Test Case
    void testStandardCase() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6; // Trapped water
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 6
    }

    @Test
        // Test Case 2: Array with all bars of height 0
    void testAllZeroHeights() {
        int[] arr = {0, 0, 0, 0, 0};
        int expected = 0; // No water can be trapped
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 0
    }

    @Test
        // Test Case 3: Array with only one bar
    void testSingleBar() {
        int[] arr = {1};
        int expected = 0; // No water can be trapped
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 0
    }

    @Test
        // Test Case 4: Array with no valleys (non-decreasing)
    void testNonDecreasingArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 0; // No water can be trapped
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 0
    }

    @Test
        // Test Case 5: Array with no peaks (non-increasing)
    void testNonIncreasingArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int expected = 0; // No water can be trapped
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 0
    }

    @Test
        // Test Case 6: Array with alternating heights
    void testAlternatingHeights() {
        int[] arr = {1, 0, 1, 0, 1};
        int expected = 2; // Water can be trapped between the 1s
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 2
    }

    @Test
        // Test Case 7: Boundary value test case - Large array with peaks and valleys
    void testLargeArray() {
        int[] arr = new int[100];
        for (int i = 0; i < 50; i++) {
            arr[i] = 0;
        }
        for (int i = 50; i < 100; i++) {
            arr[i] = 1;
        }
        int expected = 0; // No water can be trapped because no valleys
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 0
    }

    @Test
        // Test Case 8: Arithmetic Operator Replacement Mutation
    void testArithmeticOperatorMutation() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6; // No change in logic after mutation
        // Replacing the `+` operator inside the calculation with `-` would change the total.
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 6
    }

    @Test
        // Test Case 9: Relational Operator Replacement Mutation
    void testRelationalOperatorMutation() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6; // No change in logic after mutation
        // Changing the equality check `==` to `!=` in the condition will impact the water trapping logic.
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 6
    }

    @Test
        // Test Case 10: Boundary Value Change Mutation
    void testBoundaryValueChange() {
        int[] arr = {1, 2, 1, 2, 1, 2};
        int expected = 2; // Water can be trapped between the second and fourth bars
        // Modifying the boundary or array size will change the calculation of trapped water.
        assertEquals(expected, TrappingRainwater.trap(arr));  // Expected output: 2
    }

}