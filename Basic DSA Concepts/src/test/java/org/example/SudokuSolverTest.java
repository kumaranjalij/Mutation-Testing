package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//
//Statement Deletion: This operator deletes a statement in the code. If the test case detects the absence of this statement, it means the mutation was detected.
//Conditional Boundary Change (Relational Operator): This mutation changes the boundary or relational operator in a conditional statement. For example, changing a == to != or a > to <.
//Inserting a Literal Value: This operator involves replacing a variable or constant with a literal value to check if the program can still function correctly under different assumptions.
//
//Integration-Level Mutation Operators:
//
//Method Deletion: This mutation deletes an entire method to verify if the system behaves correctly when a method is missing.
//Method Insertion: This operator introduces a new, unnecessary method to check if it disrupts the normal flow.
//Function Signature Mutation: This operator alters a function's signature, such as changing the parameter types or return types. The purpose is to see if the system breaks or if the tests catch such a failure.

class SudokuSolverTest {

    // Test case 1: Basic test case for a Sudoku puzzle
    @Test
    public void testBasicSudoku() {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        char[][] expected = {
                {'9', '5', '7', '6', '1', '3', '2', '8', '4'},
                {'4', '8', '3', '2', '5', '7', '1', '9', '6'},
                {'6', '1', '2', '8', '4', '9', '5', '3', '7'},
                {'1', '7', '8', '3', '6', '4', '9', '5', '2'},
                {'5', '2', '4', '9', '7', '1', '3', '6', '8'},
                {'3', '6', '9', '5', '2', '8', '7', '4', '1'},
                {'8', '4', '5', '7', '9', '2', '6', '1', '3'},
                {'2', '9', '1', '4', '3', '6', '8', '7', '5'},
                {'7', '3', '6', '1', '8', '5', '4', '2', '9'}
        };

        SudokuSolver.solveSudoku(board);
        assertArrayEquals(expected, board);
    }

    // Helper to check if a solved board is valid
    private boolean isSudokuValid(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i) ||
                            !seen.add(num + " in col " + j) ||
                            !seen.add(num + " in box " + i/3 + "-" + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

//    Test case 2 : Empty Board Test
    @Test
    public void testEmptyBoard() {
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], '.');
        }

        SudokuSolver.solveSudoku(board);
        assertTrue(isSudokuValid(board)); // Custom helper to validate Sudoku constraints
    }

//    Statement Deletion Mutation: Tests if removing a key check in the isValid method is caught by the test.
    @Test
    public void testStatementDeletionMutation() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSolver.solveSudoku(board);
        assertTrue(isSudokuValid(board)); // Detects issues if row/column checks are deleted
    }

//    Relational Operator Mutation: Replacing == with != in isValid will make invalid placements pass. This test should fail if that mutation exists.
    @Test
    public void testRelationalOperatorMutation() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        SudokuSolver.solveSudoku(board);
        assertTrue(isSudokuValid(board));
    }

    // Mutation Test 3: Method Deletion Mutation (Remove the solveSudoku method)
    @Test
    public void testMethodDeletionMutation() {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        SudokuSolver.solveSudoku(board);
        assertTrue(isSudokuValid(board));
    }

    // Mutation Test 4: Method Insertion Mutation (Insert an unnecessary method)
    @Test
    public void testMethodInsertionMutation() {
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };
        // New method insertion, just verifying no side effect on Sudoku-solving process
        SudokuSolver.solveSudoku(board);
        assertTrue(isSudokuValid(board));
    }
}