package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutation Operators:
//Relational Operator Mutation: Changes logical conditions (< to <= or ==).
//Arithmetic Operator Mutation: Alters arithmetic operations (+ to -, * to /).
//Statement Deletion Mutation: Removes key statements, such as adj.add() or break.

//Integration-Level Mutation Operators:
//Data Flow Mutation: Changes input sequences or manipulates adjacency lists.
//Method Call Mutation: Modifies method calls to simulate integration failures.
//Loop Boundary Mutation: Alters loop termination conditions.

class AlienDictionaryTopoSortTest {

    // Helper to run and validate the Alien Dictionary order
    void validateOrder(String[] dict, int N, int K, String expectedOrder) {
        String actualOrder = AlienDictionaryTopoSort.findOrder(dict, N, K);
        assertEquals(expectedOrder, actualOrder);
    }

    // Unit-Level Tests
//    ROM
    @Test
    void testBasicCase() {
        // Mutation: Relational Operator (< to <=)
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        validateOrder(dict, 5, 4, "bdac");
    }

//    SDM
    @Test
    void testSingleCharacterWords() {
        // Mutation: Statement Deletion (Remove adj.add())
        String[] dict = {"a", "b", "c"};
        validateOrder(dict, 3, 3, "abc");
    }

//    AOM
    @Test
    void testIdenticalWords() {
        // Mutation: Arithmetic Operator (- to +)
        String[] dict = {"abc", "abc"};
        validateOrder(dict, 2, 3, "abc");
    }

//    LBM
    @Test
    void testDifferentLengths() {
        // Mutation: Loop Boundary (Change ptr < len to ptr <= len)
        String[] dict = {"abc", "ab"};
        validateOrder(dict, 2, 3, "abc");
    }

    // Integration-Level Tests
//    DFM
    @Test
    void testReverseOrder() {
        // Mutation: Data Flow (adjacency reversed)
        String[] dict = {"cba", "abc"};
        validateOrder(dict, 2, 3, "bca");
    }

//    MCM
    @Test
    void testDisconnectedGraph() {
        // Mutation: Method Call (Skip topoSort call)
        String[] dict = {"ab", "cd"};
        validateOrder(dict, 2, 4, "abdc");
    }

    @Test
    void testSingleWord() {
        // Mutation: Skip edge creation
        String[] dict = {"abc"};
        validateOrder(dict, 1, 3, "abc");
    }

    @Test
    void testMultipleEdges() {
        // Mutation: Remove indegree update
        String[] dict = {"a", "b", "ba", "c"};
        validateOrder(dict, 4, 3, "abc");
    }

    @Test
    void testLargeDictionary() {
        // Mutation: Loop Boundary Mutation (Increase V to invalid value)
        String[] dict = {"a", "aa", "aaa", "aaaa"};
        validateOrder(dict, 4, 1, "a");
    }

}