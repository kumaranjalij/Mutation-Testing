package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-level Mutation Operators:
//Arithmetic Operator Replacement (AOR): Replace + with - or other arithmetic operators.
//Constant Replacement (CR): Change constants like Integer.MIN_VALUE or Math.pow(-10, 9) to different values.
//Conditional Boundary Mutation (CBM): Modify conditions (e.g., == to !=).

//Integration-level Mutation Operators:
//Loop Boundary Change: Adjust loop boundaries (< m to <= m).
//Array Index Change: Introduce incorrect indices in array access.
//Method Call Mutation: Change clone() to an incorrect method.

class NinjaAndFriendsTest {

    @Test
    public void testSmallGrid() {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };
        Assertions.assertEquals(10, NinjaAndFriends.maximumChocolates(2, 2, grid));
        // Kills AOR mutation: changing `+` to `-`.
    }

    @Test
    public void testAllZeros() {
        int[][] grid = {
                {0, 0},
                {0, 0}
        };
        Assertions.assertEquals(0, NinjaAndFriends.maximumChocolates(2, 2, grid));
        // Kills constant replacement mutation: changing zero to other values.
    }

    @Test
    public void testNegativeValues() {
        int[][] grid = {
                {-1, -2},
                {-3, -4}
        };
        Assertions.assertEquals(-6, NinjaAndFriends.maximumChocolates(2, 2, grid));
        // Kills boundary mutation: negative values handling.
    }

    @Test
    public void testLargeGrid() {
        int[][] grid = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {5, 6, 7, 8}
        };
        Assertions.assertEquals(25, NinjaAndFriends.maximumChocolates(3, 4, grid));
        // Kills array index mutation: ensuring correct bounds.
    }

    @Test
    public void testSingleRow() {
        int[][] grid = {{3, 4, 5, 6}};
        Assertions.assertEquals(9, NinjaAndFriends.maximumChocolates(1, 4, grid));
        // Kills loop boundary mutation: handling single-row grids.
    }

    @Test
    public void testSingleColumn() {
        int[][] grid = {
                {1},
                {2},
                {3},
                {4}
        };
        Assertions.assertEquals(10, NinjaAndFriends.maximumChocolates(4, 1, grid));
        // Kills integration-level mutation: checks vertical path handling.
    }

    @Test
    public void testUnequalValues() {
        int[][] grid = {
                {2, 9},
                {1, 3},
                {5, 1}
        };
        Assertions.assertEquals(21, NinjaAndFriends.maximumChocolates(3, 2, grid));
        // Kills arithmetic operator mutation: ensures correct summation.
    }

    @Test
    public void testLargeValues() {
        int[][] grid = {
                {1000, 2000},
                {3000, 4000},
                {5000, 6000}
        };
        Assertions.assertEquals(21000, NinjaAndFriends.maximumChocolates(3, 2, grid));
        // Kills constant mutation: handling large integers correctly.
    }

}