package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Replacement Mutation (R): Changes an arithmetic operation (e.g., + to -).
//Inversion Mutation (I): Inverts a comparison (e.g., >= to <).
//Deletion Mutation (D): Deletes a critical line or loop.

//Integration-Level Mutation Operators:
//State Mutation (S): Changes the input data to simulate different conditions.
//Control Flow Mutation (C): Modifies loop conditions or limits to simulate alternative paths.
//Boundary Mutation (B): Alters boundary values, such as making k very large or very small.

class FrogJumpTest {

//    Test Case 1: Single Step : State Mutation (S)
    @Test
    public void testSingleStep() {
        int[] height = {5};
        int k = 1;

        assertEquals(0, FrogJump.solve(height.length, height, k));
    }

//    Test Case 2: Same Height Steps : Replacement Mutation (R)
    @Test
    public void testSameHeightSteps() {
        int[] height = {10, 10, 10, 10};
        int k = 2;

        assertEquals(0, FrogJump.solve(height.length, height, k));
    }

//    Test Case 3: Max Jump Size : Boundary Mutation (B)
    @Test
    public void testMaxJumpSize() {
        int[] height = {1, 2, 3, 4, 5};
        int k = 4;

        int expected = 4;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//    Test Case 5: Negative Heights : State Mutation (S)
    @Test
    public void testNegativeHeights() {
        int[] height = {-10, -20, -30, -40};
        int k = 2;

        int expected = 30;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//    Test Case 6: All Jumps of 1 Height Difference : Control Flow Mutation (C)
    @Test
    public void testIncrementalHeights() {
        int[] height = {1, 2, 3, 4, 5};
        int k = 2;

        int expected = 4;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//     Test Case 7: Descending Heights : Inversion Mutation (I)
    @Test
    public void testDescendingHeights() {
        int[] height = {50, 40, 30, 20, 10};
        int k = 3;

        int expected = 40;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//    Test Case 8: Small k (1 Jump Limit) : Boundary Mutation (B)
    @Test
    public void testSmallJumpLimit() {
        int[] height = {1, 100, 1, 100, 1};
        int k = 1;

        int expected = 396;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//  Test Case 9: Large Input Array : Data Flow Mutation (D)
    @Test
    public void testLargeInputArray() {
        int[] height = new int[1000];
        for (int i = 0; i < 1000; i++) height[i] = i;
        int k = 50;

        int expected = 999;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

//    Test Case 10: Edge Case with Large k : Boundary Mutation (B)
    @Test
    public void testEdgeCaseLargeK() {
        int[] height = {10, 20, 30, 40, 50};
        int k = 10;

        int expected = 40;
        assertEquals(expected, FrogJump.solve(height.length, height, k));
    }

}