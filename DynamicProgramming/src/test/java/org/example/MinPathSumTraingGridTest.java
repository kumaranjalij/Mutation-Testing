package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Unit-level Mutation Operators:
//    Arithmetic Operator Replacement (AOR): Replace + with - or other arithmetic operators.
//    Logical Operator Replacement (LOR): Replace <= with >=, etc.
//    Constant Replacement (CR): Change constant values.

//Integration-level Mutation Operators:
//    Loop Boundary Change: Modify loop conditions to test off-by-one errors.
//    Array Index Change: Access incorrect indices within arrays.
//    Method Call Mutation: Replace method calls with other methods or incorrect parameters.

class MinPathSumTraingGridTest {

    @Test
    public void testSmallTriangle() {
        int[][] triangle = {
                {1},
                {2, 3},
                {3, 4, 5}
        };
        Assertions.assertEquals(6, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills arithmetic mutation: changing `+` to `-`.
    }

    @Test
    public void testNegativeValues() {
        int[][] triangle = {
                {-1},
                {-2, -3},
                {-3, -4, -5}
        };
        Assertions.assertEquals(-9, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills boundary mutation: incorrect handling of negative numbers.
    }

    @Test
    public void testAllOnes() {
        int[][] triangle = {
                {1},
                {1, 1},
                {1, 1, 1}
        };
        Assertions.assertEquals(3, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills constant mutation: replacing `1` with other values.
    }

    @Test
    public void testLargeTriangle() {
        int[][] triangle = {
                {5},
                {9, 6},
                {4, 6, 8},
                {0, 7, 1, 5}
        };
        Assertions.assertEquals(18, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills array index mutation: accessing out-of-bound indices.
    }

    @Test
    public void testSingleRow() {
        int[][] triangle = {{7}};
        Assertions.assertEquals(7, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills integration mutation: handling of a single-element grid.
    }

    @Test
    public void testUnevenValues() {
        int[][] triangle = {
                {2},
                {5, 4},
                {1, 7, 3},
                {8, 2, 0, 6}
        };
        Assertions.assertEquals(9, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills arithmetic mutation: changing min to max.
    }

    @Test
    public void testDescendingTriangle() {
        int[][] triangle = {
                {10},
                {9, 8},
                {7, 6, 5},
                {4, 3, 2, 1}
        };
        Assertions.assertEquals(24, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills loop boundary mutation: incorrect loop exit condition.
    }

    @Test
    public void testZigZagPath() {
        int[][] triangle = {
                {1},
                {2, 3},
                {10, 1, 2},
                {4, 5, 6, 1}
        };
        Assertions.assertEquals(7, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills logical mutation: modifying row access condition.
    }

    @Test
    public void testLargeValues() {
        int[][] triangle = {
                {1000},
                {800, 600},
                {400, 500, 300},
                {200, 100, 50, 20}
        };
        Assertions.assertEquals(1920, MinPathSumTraingGrid.minimumPathSum(triangle, triangle.length));
        // Kills constant mutation: replacing large values.
    }
}