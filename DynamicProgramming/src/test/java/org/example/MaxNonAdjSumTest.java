package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Arithmetic Operator Replacement (AOR): Changes arithmetic operations (+ to -).
//Conditional Operator Replacement (COR): Changes comparison operators (> to >=).
//Logical Negation (LN): Inverts boolean expressions (like negating loop conditions).

//Integration-Level Mutation Operators:
//Boundary Mutation (B): Modifies the array size or input values at boundaries.
//Data Flow Mutation (DF): Changes input data to test different paths and states.
//Control Flow Mutation (CF): Alters loop conditions or sequence control structures.

class MaxNonAdjSumTest {

//    Single Element : Data Flow Mutation (DF)
    @Test
    public void testSingleElement() {
        int[] arr = {5};
        int expected = 5;
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    Two Elements : Control Flow Mutation (CF)
    @Test
    public void testTwoElements() {
        int[] arr = {3, 7};
        int expected = 7; // Only one element can be picked.
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    All Positive Elements : Arithmetic Operator Replacement (AOR)
    @Test
    public void testAllPositiveElements() {
        int[] arr = {3, 2, 5, 10, 7};
        int expected = 15; // 3 + 5 + 7 or 3 + 10
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    Mixed Positive and Negative Elements : Logical Negation (LN)
    @Test
    public void testMixedElements() {
        int[] arr = {3, -2, 7, -5, 8};
        int expected = 18; // 3 + 7 + 8
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    Zeroes in Array : Data Flow Mutation (DF)
    @Test
    public void testWithZeroes() {
        int[] arr = {0, 3, 0, 2};
        int expected = 5; // 3 + 2
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    Large Input Values : Boundary Mutation (B)
    @Test
    public void testLargeInputValues() {
        int[] arr = {1000, 2000, 3000, 4000};
        int expected = 6000; // 1000 + 3000 or 2000 + 4000
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//     Alternating Small and Large Values : Arithmetic Operator Replacement (AOR)
    @Test
    public void testAlternatingValues() {
        int[] arr = {1, 100, 1, 100};
        int expected = 200; // 100 + 100
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }

//    Long Array with Small Values :Control Flow Mutation (CF)
    @Test
    public void testLongArraySmallValues() {
        int[] arr = new int[100];
        Arrays.fill(arr, 1);
        int expected = 50; // Half of the elements picked (non-adjacent).
        assertEquals(expected, MaxNonAdjSum.solve(arr.length, arr));
    }
}