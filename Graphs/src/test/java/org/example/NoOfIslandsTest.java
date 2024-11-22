package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit Level Mutation Operators:
//Relational Operator Replacement (ROR): Changes comparison operators (like == to != or < to <=).
//Logical Operator Replacement (LOR): Changes logical operators (&& to || or vice versa).
//Constant Replacement (CR): Alters constant values in the code.

//Integration Level Mutation Operators:
//Conditional Block Removal (CBR): Removes entire conditional blocks to simulate missing logic.
//Method Call Removal (MCR): Deletes method calls to check if critical functionality is missing.
//Loop Unrolling or Removal (LUR): Changes loop behavior, simulating loop boundary errors.

class NoOfIslandsTest {

    // Test case 1: Basic scenario with a small grid. : ROR
    @Test
    public void testSmallGrid() {
        char[][] grid = {
                {'1', '0'},
                {'0', '1'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // ROR killed (changed == to !=)
    }

    // Test case 2: Grid with all water. :LOR
    @Test
    public void testAllWater() {
        char[][] grid = {
                {'0', '0'},
                {'0', '0'}
        };
        assertEquals(0, NoOfIslands.numIslands(grid));  // LOR killed (changed && to ||)
    }

    // Test case 3: Single island spanning the entire grid. :CR
    @Test
    public void testSingleIsland() {
        char[][] grid = {
                {'1', '1'},
                {'1', '1'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // CR killed (changed '1' to '0')
    }

    // Test case 4: Vertical islands. :CBR
    @Test
    public void testVerticalIslands() {
        char[][] grid = {
                {'1', '0'},
                {'1', '0'},
                {'1', '0'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // CBR killed (conditional block removed)
    }

    // Test case 5: Horizontal islands. :LUR
    @Test
    public void testHorizontalIslands() {
        char[][] grid = {
                {'1', '1', '1'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // LUR killed (loop modification)
    }

    // Test case 6: Diagonal islands. :MCR
    @Test
    public void testDiagonalIslands() {
        char[][] grid = {
                {'1', '0', '1'},
                {'0', '1', '0'},
                {'1', '0', '1'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // MCR killed (method call removed)
    }

    // Test case 7: Large grid with multiple islands. :ROR
    @Test
    public void testLargeGrid() {
        char[][] grid = {
                {'1', '0', '1', '0'},
                {'0', '1', '0', '1'},
                {'1', '0', '1', '0'}
        };
        assertEquals(1, NoOfIslands.numIslands(grid));  // ROR killed (boundary condition)
    }

    // Test case 8: Mixed grid with isolated water. :CR
    @Test
    public void testMixedGrid() {
        char[][] grid = {
                {'1', '0', '1'},
                {'1', '0', '1'}
        };
        assertEquals(2, NoOfIslands.numIslands(grid));  // CR killed (constant modification)
    }

    // Test case 9: Empty grid. :CBR
    @Test
    public void testEmptyGrid() {
        char[][] grid = {};
        assertEquals(0, NoOfIslands.numIslands(grid));  // CBR killed (conditional check)
    }

    // Test case 10: Irregular grid. :LUR
    @Test
    public void testIrregularGrid() {
        char[][] grid = {
                {'1'},
                {'0'},
                {'1'}
        };
        assertEquals(2, NoOfIslands.numIslands(grid));  // LUR killed (loop alteration)
    }

}