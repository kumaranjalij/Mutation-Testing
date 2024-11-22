package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit Level Mutation Operators:
//Replacement Mutation (R): Replace a part of the code (such as a variable or operator) with another value to see if the code still works.
//Inversion Mutation (I): Invert the logic of comparison operators (e.g., < to >, <= to >=) to check if the logic is correct.
//Deletion Mutation (D): Delete a statement or part of a block to check if the program still functions correctly when critical parts are missing.

//Integration Level Mutation Operators:
//State Mutation (S): Change an initial variable or input, like modifying the input arrays (arr or dep), to check if the logic is sensitive to changes in the data.
//Control Flow Mutation (C): Modify the flow control, like changing the loop condition or switching the order of operations in if-else conditions.
//Data Flow Mutation (F): Modify how data is passed or used within the program, such as changing the order of elements in the input arrays or swapping arr and dep.

class MinNoOfPlatformsTest {

//    Deletion Mutation (D)
    @Test
    public void testNoOverlap() {
        int[] arr = {900, 1000, 1100};
        int[] dep = {920, 1030, 1130};
        int n = arr.length;

        // Expected result: 1 (No overlap, so only 1 platform required)
        assertEquals(1, MinNoOfPlatforms.findPlatform(arr, dep, n));
    }

//  Inversion Mutation (I)
    @Test
    public void testSameTime() {
        int[] arr = {900, 900, 900};
        int[] dep = {920, 920, 920};
        int n = arr.length;

        // Expected result: 3 (All arrivals at the same time, 3 platforms required)
        assertEquals(3, MinNoOfPlatforms.findPlatform(arr, dep, n));
    }

//    State Mutation (S)
    @Test
    public void testAllDeparturesBeforeArrivals() {
        int[] arr = {1500, 1600, 1700};
        int[] dep = {1400, 1500, 1600};
        int n = arr.length;

        // Expected result: 1 (Since no platforms overlap, only one platform needed)
        assertEquals(1, MinNoOfPlatforms.findPlatform(arr, dep, n));
    }

//    Replacement Mutation (R)
    @Test
    public void testDescendingArrivals() {
        int[] arr = {1800, 1500, 1200, 1000};
        int[] dep = {1900, 1600, 1300, 1100};
        int n = arr.length;

        // Expected result: 1 (No overlaps, hence 1 platform required)
        assertEquals(1, MinNoOfPlatforms.findPlatform(arr, dep, n));
    }

//    Deletion Mutation (D)
    @Test
    public void testAllDeparturesSame() {
        int[] arr = {900, 1000, 1100};
        int[] dep = {1200, 1200, 1200};
        int n = arr.length;

        // Expected result: 3 (All depart at the same time, so 3 platforms required)
        assertEquals(3, MinNoOfPlatforms.findPlatform(arr, dep, n));
    }

//    Data Flow Mutation (F)
    @Test
    public void testLargeInput() {
        int[] arr = new int[1000];
        int[] dep = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i * 100;
            dep[i] = i * 100 + 50;
        }
        int n = arr.length;

        // The exact result isn't known here but this test ensures scalability.
        assertTrue(MinNoOfPlatforms.findPlatform(arr, dep, n) > 0);
    }
}