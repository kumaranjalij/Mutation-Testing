package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepetitionTest {

    // Test Case 1: Regular test with a string having unique characters
    @Test
    public void testNormalCase() {
        String str = "takeUforward";
        assertEquals(9, LongestSubstringWithoutRepetition.solve(str)); // Expected longest substring: "takeUfor"
        // Kills AOR: Tests if the code can handle normal cases correctly.
    }

    // Test Case 2: String with only one character (edge case)
    @Test
    public void testSingleCharacter() {
        String str = "a";
        assertEquals(1, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 1
        // Kills Boundary Value Mutation: Ensures that single character input is handled correctly.
    }

    // Test Case 3: String with all identical characters (e.g., "aaaaa")
    @Test
    public void testIdenticalCharacters() {
        String str = "aaaaa";
        assertEquals(1, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 1
        // Kills AOR: Tests how the code handles repetitive characters (checks the use of Set).
    }

    // Test Case 4: String with an empty input
    @Test
    public void testEmptyString() {
        String str = "";
        assertEquals(0, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 0
        // Kills Boundary Value Mutation: Tests if the function can handle empty strings.
    }

    // Test Case 5: String with alternating characters (e.g., "ababab")
    @Test
    public void testAlternatingCharacters() {
        String str = "ababab";
        assertEquals(2, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 2 (substrings: "ab")
        // Kills AOR: Tests if the logic handles alternating characters correctly.
    }

    // Test Case 6: String where the longest substring is at the beginning
    @Test
    public void testSubstringAtBeginning() {
        String str = "abcdabc";
        assertEquals(4, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 4 (substring: "abcd")
        // Kills ROR: Tests how the program handles substrings that start at the beginning of the string.
    }

    // Test Case 8: String with a large length of unique and repeated characters
    @Test
    public void testLargeInput() {
        String str = "abcdefghijklmnaaaaaaa";
        assertEquals(14, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 14 (substring: "abcdefghijklm")
        // Kills Parameter Mutation: Tests large input to ensure the algorithm works efficiently.
    }

    // Test Case 10: String where a repeating character appears late
    @Test
    public void testLateRepetition() {
        String str = "abcdeabcde";
        assertEquals(5, LongestSubstringWithoutRepetition.solve(str)); // Expected result: 5 (substring: "abcde")
        // Kills CFM: Tests handling of late repetitions within the string.
    }

}