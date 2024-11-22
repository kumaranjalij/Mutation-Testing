package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Unit-level mutations:
//Relational Operator Mutation(ROM): Change <= to < or >= to >.
//Statement Deletion Mutation(SDM): Remove key lines.
//Arithmetic Operator Mutation(AOM): Modify expressions like mid1 - 1 to mid1 + 1.

//Integration-level mutations:
//Data Flow Mutation(DFM): Pass arrays in reverse order.
//Loop Boundary Mutation(LBM): Change loop conditions.
//Method Parameter Mutation(MPM): Changes input values or array sizes during the method call.

class KthElementOfTwoSortedArraysTest {

//    Basic Case: Tests correct output for normal input with distinct elements.
//    AOM :Detects incorrect calculations of split indices.
    @Test
    public void testBasicCase() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 4, 8, 10));
        int k = 5;

        int expected = 6;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

    //    k-th element is entirely in one array.
//    LBM: Ensures loops traverse the full length of both arrays without missing elements.
    @Test
    public void testAllElementsInOneArray() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        int k = 7;

        int expected = 7;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    both arrays contain only one element. => SDM: Tests the absence of key logic handling minimal input.
//    LBM: Validates loop handling with duplicate values.
    @Test
    public void testSingleElementArrays() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(7));
        int k = 2;

        int expected = 7;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    arrays with duplicate values.
    @Test
    public void testDuplicateElements() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 2, 3, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(3, 3, 4, 4));
        int k = 5;

        int expected = 3;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    Edge Case: k=1 => ROM: Mutations in if (l1 <= r2 && l2 <= r1) will impact this edge case.
//    MPM: Validates method behavior for boundary values.
    @Test
    public void testKEqualsOne() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5, 6));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 3));
        int k = 1;

        int expected = 2;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    Large k: k equals the combined length of both arrays.
//    AOM: Validates correctness when k is at the boundary, ensuring the arithmetic within the loop works as expected.
    @Test
    public void testLargeK() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4, 5, 6));
        int k = 6;

        int expected = 6;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    One array is empty => SDM: Ensures no missing logic when handling empty arrays.
    @Test
    public void testEmptyArray() {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 3, 5));
        int k = 2;

        int expected = 3;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    Arrays are reversed => DFM: Verifies the result is independent of array order.
    @Test
    public void testReverseArrays() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(8, 10, 12));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 3, 4));
        int k = 4;

        int expected = 8;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(b, a, b.size(), a.size(), k));
    }

//    When k is at the start of array b.
//    DFM: Checks consistency when the smallest element is in the second array.
    @Test
    public void testSingleKElement() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(10, 12));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1, 3));
        int k = 1;

        int expected = 1;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

//    negative and positive elements => ROM: Ensures conditions work correctly with both negative and positive values, detecting changes in condition logic.
//    MPM: Ensures correct results with varied input types, checking method robustness.
    @Test
    public void testNegativeAndPositive() {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(-5, -3, -1));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(2, 4, 6));
        int k = 4;

        int expected = 2;
        assertEquals(expected, KthElementOfTwoSortedArrays.kthElement(a, b, a.size(), b.size(), k));
    }

}