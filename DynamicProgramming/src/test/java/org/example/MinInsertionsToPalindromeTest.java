package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Arithmetic Operator Replacement (AOR): Changes arithmetic operations (+ to -).
//Relational Operator Replacement (ROR): Alters relational conditions (== to !=).
//Off-by-One Error (OBO): Modifies loop boundaries (<= to <).

//Integration-Level Mutation Operators:
//Data Flow Mutation (DF): Changes input strings to explore different code paths.
//Boundary Mutation (B): Tests empty strings, single-character strings, etc.
//Control Flow Mutation (CF): Alters the order or structure of nested loops or conditional blocks.

class MinInsertionsToPalindromeTest {

//    Basic
    @Test
    public void testPalindromeString() {
        String s = "racecar"; // Already a palindrome
        int expected = 0;
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Single Character : Boundary Mutation (B)
    @Test
    public void testSingleCharacter() {
        String s = "a";
        int expected = 0;
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Empty String : Boundary Mutation (B)
    @Test
    public void testEmptyString() {
        String s = "";
        int expected = 0;
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Two Different Characters : Off-by-One Error (OBO)
    @Test
    public void testTwoDifferentCharacters() {
        String s = "ab";
        int expected = 1; // Insert 'a' or 'b' to make "aba" or "bab"
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    String with Repeated Characters : Relational Operator Replacement (ROR)
    @Test
    public void testRepeatedCharacters() {
        String s = "aaaa";
        int expected = 0; // Already a palindrome
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Non-Palindromic Short String : Arithmetic Operator Replacement (AOR)
    @Test
    public void testNonPalindromeShort() {
        String s = "abc";
        int expected = 2; // Convert to "abcba"
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Complex Palindrome Requirement : Control Flow Mutation (CF)
    @Test
    public void testComplexPalindrome() {
        String s = "abcaa";
        int expected = 2; // Convert to "aacaa" or "abcacba"
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Large Input String : Boundary Mutation (B)
    @Test
    public void testLargeInputString() {
        String s = "abcdefgh";
        int expected = 7; // Add 7 characters to make palindrome
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }

//    Random Characters and Length : Relational Operator Replacement (ROR)
    @Test
    public void testRandomCharacters() {
        String s = "xabay";
        int expected = 2; // Convert to "xabax" or similar
        assertEquals(expected, MinInsertionsToPalindrome.minInsertion(s));
    }
}