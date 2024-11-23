package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Replacement Mutation (R): Changes comparison operators (< to <=).
//Inversion Mutation (I): Reverses loop directions or conditions.
//Deletion Mutation (D): Removes critical operations or lines (e.g., removing dp1 or dp2 initialization).

//Integration-Level Mutation Operators:
//Boundary Mutation (B): Alters the array size or input values at boundaries.
//Data Flow Mutation (DF): Changes input data to simulate different states.
//Control Flow Mutation (CF): Modifies loop conditions or sequences.

class LongestBitonicSubsequenceTest {

//    Single Element : State Mutation (DF)
    @Test
    public void testSingleElement() {
        int[] arr = {5};
        int expected = 1;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//  Strictly Increasing Sequence : Replacement Mutation (R)
    @Test
    public void testStrictlyIncreasing() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 5;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Strictly Decreasing Sequence : Inversion Mutation (I)
    @Test
    public void testStrictlyDecreasing() {
        int[] arr = {5, 4, 3, 2, 1};
        int expected = 5;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    All Equal Elements : Boundary Mutation (B)
    @Test
    public void testAllEqualElements() {
        int[] arr = {7, 7, 7, 7, 7};
        int expected = 1;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Two Elements Increasing : Data Flow Mutation (DF)
    @Test
    public void testTwoElementsIncreasing() {
        int[] arr = {1, 2};
        int expected = 2;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Two Elements Decreasing : Control Flow Mutation (CF)
    @Test
    public void testTwoElementsDecreasing() {
        int[] arr = {2, 1};
        int expected = 2;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Large Input Array : Boundary Mutation (B)
    @Test
    public void testLargeInputArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < 500; i++) arr[i] = i;
        for (int i = 500; i < 1000; i++) arr[i] = 1000 - i;

        int expected = 1000;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Random Values :  State Mutation (DF)
    @Test
    public void testRandomValues() {
        int[] arr = {10, 5, 14, 2, 7, 3, 12};
        int expected = 4;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }

//    Long Plateau : Control Flow Mutation (CF)
    @Test
    public void testLongPlateau() {
        int[] arr = {1, 2, 2, 2, 1};
        int expected = 3;
        assertEquals(expected, LongestBitonicSubsequence.longestBitonicSequence(arr, arr.length));
    }
}