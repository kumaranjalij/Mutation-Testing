package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    // Test Case 1: Basic test where strings are anagrams
    @Test
    public void testAnagramTrue() {
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills AOR: Verifies correct anagram result.
    }

    // Test Case 2: Strings with different lengths (cannot be anagrams)
    @Test
    public void testDifferentLengthStrings() {
        String str1 = "INTEGER";
        String str2 = "INTEGERS";
        assertEquals(false, Anagrams.checkAnagrams(str1, str2));
        // Kills ROR: Ensures that different lengths are correctly handled by != operator.
    }

    // Test Case 3: Both strings are empty
    @Test
    public void testEmptyStrings() {
        String str1 = "";
        String str2 = "";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills Boundary Value mutation: Tests handling of empty strings.
    }

    // Test Case 4: One string is empty
    @Test
    public void testOneEmptyString() {
        String str1 = "INTEGER";
        String str2 = "";
        assertEquals(false, Anagrams.checkAnagrams(str1, str2));
        // Kills Boundary Value mutation: Ensures empty string comparison returns false.
    }

    // Test Case 5: Strings with same characters but different order
    @Test
    public void testSameCharactersDifferentOrder() {
        String str1 = "LISTEN";
        String str2 = "SILENT";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills CFM: Checks the correct sorting and matching of characters.
    }

    // Test Case 6: Strings with similar but not identical characters
    @Test
    public void testSimilarCharacters() {
        String str1 = "HELLO";
        String str2 = "HOLLE";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills MCR: Verifies that characters are handled correctly after sorting.
    }

    // Test Case 7: Identical strings
    @Test
    public void testIdenticalStrings() {
        String str1 = "ABCDE";
        String str2 = "ABCDE";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills Parameter Mutation: Ensures identical strings are considered anagrams.
    }

    // Test Case 8: Strings with special characters
    @Test
    public void testSpecialCharacters() {
        String str1 = "a!b@c#";
        String str2 = "#b@c!a";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills ROR: Verifies that special characters are handled correctly.
    }

    // Test Case 9: Strings with different characters
    @Test
    public void testDifferentCharacters() {
        String str1 = "STRING";
        String str2 = "OTHER";
        assertEquals(false, Anagrams.checkAnagrams(str1, str2));
        // Kills AOR: Ensures strings with different characters are not considered anagrams.
    }

    // Test Case 10: Strings with large input
    @Test
    public void testLargeStrings() {
        String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str2 = "ZYXWVUTSRQPONMLKJIHGFEDCBAZYXWVUTSRQPONMLKJIHGFEDCBA";
        assertEquals(true, Anagrams.checkAnagrams(str1, str2));
        // Kills Control Flow Mutation: Verifies handling of large input strings.
    }

}