package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutations:
//Arithmetic Operator Replacement (AOR): Replace arithmetic operators like +, -, or * with different operators.
//Relational Operator Replacement (ROR): Replace relational operators (like <, <=, ==) with others (e.g., >, >=).
//Logical Connector Replacement (LCR): Modify logical connectors like && or ||.

//Integration-Level Mutations:
//Boundary Value Changes: Introduce edge cases that test boundaries (e.g., empty lists, lists with negative numbers).
//Input Parameter Changes: Modify input size or values significantly.
//Control Flow Changes: Alter conditional paths to see if test cases cover all branches.

class MinSubsetSumDiffTest {

    // Basic positive test case
    @Test
    public void testBasicCase() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(0, result); // Kills arithmetic operator mutation (AOR)
    }

    // Single element test
    @Test
    public void testSingleElement() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5));
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(5, result); // Kills boundary value mutation
    }

    // Two elements with equal values
    @Test
    public void testTwoEqualElements() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 4));
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(0, result); // Kills logical connector mutation (LCR)
    }

    // Test with all elements zero
    @Test
    public void testAllZeros() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(0, result); // Kills control flow mutation
    }

    // Large array test
    @Test
    public void testLargeArray() {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            arr.add(i);
        }
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(1, result); // Kills boundary value mutation
    }

    // Test with duplicates
    @Test
    public void testWithDuplicates() {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
        int result = MinSubsetSumDiff.minSubsetSumDifference(arr, arr.size());
        assertEquals(0, result); // Kills relational operator mutation (ROR)
    }

}