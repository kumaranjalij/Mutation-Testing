package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit Level Mutation Operators:
//Replacement Mutation (R): This mutation replaces a part of the code (e.g., a variable, value, or operator) with another one.
//Inversion Mutation (I): This mutation inverts comparison operators (e.g., changing > to < or == to !=).
//Deletion Mutation (D): This mutation deletes a statement or a portion of code to see if the program can still function correctly without it.

//Integration Level Mutation Operators:
//State Mutation (S): Changes the initial data or variables to test the algorithm's response to altered inputs.
//Control Flow Mutation (C): Alters the control flow, such as modifying conditions or loop structures, to see if the program can still handle different execution paths correctly.
//Data Flow Mutation (F): Modifies how data is passed or used within the code, such as changing the array's values or the sequence of operations in the loop.

class SlidingWindowMaximumTest {

//     State Mutation (S)
    @Test
    public void testAllNegativeNumbers() {
        int[] arr = {-5, -3, -1, -4, -2};
        int k = 3;

        // Expected result: [-1, -1, -1]
        assertArrayEquals(new int[]{-1, -1, -1}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }

//    Replacement Mutation (R)
    @Test
    public void testAllElementsSame() {
        int[] arr = {7, 7, 7, 7, 7};
        int k = 3;

        // Expected result: [7, 7, 7]
        assertArrayEquals(new int[]{7, 7, 7}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }

//    Control Flow Mutation (C)
    @Test
    public void testDescendingOrder() {
        int[] arr = {10, 9, 8, 7, 6, 5};
        int k = 3;

        // Expected result: [10, 9, 8, 7]
        assertArrayEquals(new int[]{10, 9, 8, 7}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }

//    Control Flow Mutation (C)
    @Test
    public void testAscendingOrder() {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;

        // Expected result: [3, 4, 5]
        assertArrayEquals(new int[]{3, 4, 5}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }

//    Data Flow Mutation (F)
    @Test
    public void testLargeInput() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
        }
        int k = 100;

        // Expected result: An array of size 901, with the maximum of each sliding window
        int[] result = SlidingWindowMaximum.maxSlidingWindow(arr, k);
        assertEquals(901, result.length);
    }

//    Inversion Mutation (I)
    @Test
    public void testAlternatingHighLow() {
        int[] arr = {1, 10, 1, 10, 1, 10};
        int k = 3;

        // Expected result: [10, 10, 10, 10]
        assertArrayEquals(new int[]{10, 10, 10, 10}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }

//     Replacement Mutation (R)
    @Test
    public void testLargeWindow() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 6;

        // Expected result: [6] as the window covers the entire array
        assertArrayEquals(new int[]{6}, SlidingWindowMaximum.maxSlidingWindow(arr, k));
    }


}