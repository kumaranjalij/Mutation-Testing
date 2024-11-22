package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit Level Mutation Operators:
//Statement Deletion (SDEL): Removing a statement from the code.
//Negation Insertion (NEG): Changing a condition to its negation.
//Arithmetic Operator Replacement (AROP): Modifying arithmetic operators (e.g., replacing + with -).

//Integration Level Mutation Operators:
//Method Argument Insertion (MAI): Adding an unnecessary argument to a method call.
//Method Argument Deletion (MAD): Removing an argument from a method call.
//Object Attribute Modification (OAM): Changing a field or attribute of an object in the class.

class WordLadderTest {

//    Mutation Operator: Statement Deletion (SDEL)
    @Test
    public void testTransformationPossible() {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = { "des", "der", "dfr", "dgt", "dfs" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(3, result);  // Expected steps from "der" to "dfs"
    }

//  Mutation Operator: Negation Insertion (NEG)
    @Test
    public void testNoTransformationPossible() {
        String startWord = "abc", targetWord = "xyz";
        String[] wordList = { "def", "ghi", "jkl" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(0, result);  // No transformation possible
    }

//    Mutation Operator: Arithmetic Operator Replacement (AROP)
    @Test
    public void testEmptyWordList() {
        String startWord = "cat", targetWord = "dog";
        String[] wordList = {};
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(0, result);  // No transformation possible with empty word list
    }

//    Mutation Operator: Method Argument Insertion (MAI)
    @Test
    public void testSameStartAndEndWord() {
        String startWord = "hit", targetWord = "hit";
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(1, result);  // Start and target are the same
    }

//    Mutation Operator: Method Argument Deletion (MAD)
    @Test
    public void testDifferentWordLengths() {
        String startWord = "hot", targetWord = "dog";
        String[] wordList = { "dot", "dog", "lot" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(3, result);  // Hot -> Dot -> Dog
    }

//    Mutation Operator: Object Attribute Modification (OAM)
    @Test
    public void testAdditionalWords() {
        String startWord = "hit", targetWord = "cog";
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(5, result);  // Hit -> Hot -> Dot -> Dog -> Cog
    }


//    Mutation Operator: Arithmetic Operator Replacement (AROP)
    @Test
    public void testLargeWordList() {
        String startWord = "cat", targetWord = "dog";
        String[] wordList = { "cot", "cog", "dog", "dot", "lot", "log", "cog" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(4, result);  // Cat -> Cot -> Cog -> Dog
    }

//    Mutation Operator: Method Argument Deletion (MAD)
    @Test
    public void testEarlyTargetWordMatch() {
        String startWord = "abc", targetWord = "xyz";
        String[] wordList = { "xyz", "abc", "def" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(0, result);  // Direct match (start is the target)
    }

//    Mutation Operator: Object Attribute Modification (OAM)
    @Test
    public void testUnreachableWord() {
        String startWord = "abc", targetWord = "xyz";
        String[] wordList = { "def", "ghi", "jkl" };
        int result = WordLadder.wordLadderLength(startWord, targetWord, wordList);
        assertEquals(0, result);  // No transformation possible
    }

}