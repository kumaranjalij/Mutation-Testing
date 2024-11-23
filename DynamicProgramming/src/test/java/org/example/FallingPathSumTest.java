package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Arithmetic Operator Replacement (AOR): Change arithmetic operations (+ to -, * to /).
//Relational Operator Replacement (ROR): Alter conditional checks (>= to <).
//Logical Operator Replacement (LOR): Modify logical conditions (&& to ||).

//Integration-Level Mutation Operators:
//Boundary Mutation (B): Test with boundary values like empty matrices or single-row matrices.
//Control Flow Mutation (CF): Alter loop conditions or flow logic.
//Data Flow Mutation (DF): Provide different matrix structures to explore varied execution paths.

class FallingPathSumTest {

//    base
    @Test
    public void testBasicMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 10, 4),
                Arrays.asList(100, 3, 2, 1),
                Arrays.asList(1, 1, 20, 2),
                Arrays.asList(1, 2, 2, 1)
        );
        int expected = 105; // Path: 10 -> 2 -> 20 -> 2
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

//    Single Row Matrix
    @Test
    public void testSingleRow() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(3, 7, 4, 5)
        );
        int expected = 7; // Max of single row
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

//    Single Column Matrix
    @Test
    public void testSingleColumn() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(5),
                Arrays.asList(10),
                Arrays.asList(3)
        );
        int expected = 18; // Path: 5 -> 10 -> 3
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

//    Large Positive Values
    @Test
    public void testLargePositiveValues() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1000, 2000, 3000),
                Arrays.asList(100, 200, 300),
                Arrays.asList(10, 20, 30)
        );
        int expected = 3330; // Path: 3000 -> 300 -> 30
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

//     All Zeros
    @Test
    public void testAllZeros() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 0)
        );
        int expected = 0; // All paths sum to zero
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

//    Sparse Matrix with Large Negative Values
    @Test
    public void testSparseMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(-1000, 0, -1000),
                Arrays.asList(0, -1000, 0),
                Arrays.asList(-1000, 0, -1000)
        );
        int expected = 0; // Best path: 0 -> 0 -> 0
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }

    //    Large Square Matrix
    @Test
    public void testLargeMatrix() {
        List<List<Integer>> matrix = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(5, 4, 3, 2, 1),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(5, 4, 3, 2, 1),
                Arrays.asList(1, 2, 3, 4, 5)
        );
        int expected = 19; // Optimal path through central values
        assertEquals(expected, FallingPathSum.getMaxPathSum(matrix));
    }
}