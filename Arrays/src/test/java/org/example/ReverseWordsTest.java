package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {

    @Test
        // Test Case 1: Standard Input
    void testStandardInput() {
        String st = "TUF is great for interview preparation";
        String expected = "preparation interview for great is TUF";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "preparation interview for great is TUF"
    }

    @Test
        // Test Case 2: Empty string input
    void testEmptyString() {
        String st = "";
        String expected = "";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: ""
    }

    @Test
        // Test Case 3: Single word input
    void testSingleWord() {
        String st = "Hello";
        String expected = "Hello";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "Hello"
    }

    @Test
        // Test Case 4: Only spaces input
    void testOnlySpaces() {
        String st = "     ";
        String expected = "";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: ""
    }

    @Test
        // Test Case 6: Boundary Value Case - One character word
    void testSingleCharacterWord() {
        String st = "a";
        String expected = "a";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "a"
    }

    @Test
        // Test Case 7: No spaces (only a single word)
    void testNoSpaces() {
        String st = "TUF";
        String expected = "TUF";
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "TUF"
    }

    @Test
        // Test Case 8: Control Flow Mutation - Changing condition for word addition
    void testControlFlowMutation() {
        String st = "TUF is great";
        String expected = "great is TUF";
        // Mutating the condition to change how words are added to the result (e.g., checking `left == right` instead of `left <= right`)
        // This will affect the loop behavior.
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "great is TUF"
    }

    @Test
        // Test Case 9: Relational Operator Mutation (Changing equality check)
    void testRelationalOperatorMutation() {
        String st = "Hello World";
        String expected = "World Hello";
        // Changing the equality check in the while loop to `!=` would cause an issue in word separation.
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "World Hello"
    }

    @Test
        // Test Case 10: Constant Replacement Mutation - Replace space with a different character
    void testConstantReplacementMutation() {
        String st = "Hello World";
        String expected = "World Hello";
        // Replacing the space `' '` with some other character, e.g., a comma, would result in incorrect splitting of words.
        assertEquals(expected, ReverseWords.result(st));  // Expected output: "World Hello"
    }
}