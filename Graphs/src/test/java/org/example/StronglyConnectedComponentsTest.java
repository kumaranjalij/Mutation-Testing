package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Unit-Level Mutations:
//Conditional Mutation: Change conditions in if statements.
//Loop Mutation: Alter the loop termination condition.
//Arithmetic Mutation: Change arithmetic operations (+ to -, etc.).

//Integration-Level Mutations:
//Edge Case Manipulation: Alter the input graph structure (nodes and edges).
//Method Call Manipulation: Modify function call arguments or return values.
//Graph Reversal Test: Verify if transposition logic is intact.

class StronglyConnectedComponentsTest {

    // Test 1: Simple graph with 1 node (unit-level: conditional mutation)
    @Test
    public void testSingleNode() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());  // Single node with no edges
        assertEquals(1, StronglyConnectedComponents.kosaraju(1, adj));
    }

    // Test 2: Two disconnected nodes (integration-level: edge case mutation)
    @Test
    public void testTwoDisconnectedNodes() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());  // Node 0
        adj.add(new ArrayList<>());  // Node 1
        assertEquals(2, StronglyConnectedComponents.kosaraju(2, adj));
    }

    // Test 3: Simple cycle (unit-level: loop mutation)
    @Test
    public void testSimpleCycle() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));  // 0 -> 1
        adj.add(new ArrayList<>(Arrays.asList(0)));  // 1 -> 0
        assertEquals(1, StronglyConnectedComponents.kosaraju(2, adj));
    }

    // Test 4: Chain graph (integration-level: method call mutation)
    @Test
    public void testChainGraph() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));  // 0 -> 1
        adj.add(new ArrayList<>(Arrays.asList(2)));  // 1 -> 2
        adj.add(new ArrayList<>());  // 2 -> None
        assertEquals(3, StronglyConnectedComponents.kosaraju(3, adj));
    }

    // Test 5: Graph with self-loops (unit-level: conditional mutation)
    @Test
    public void testSelfLoop() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(0)));  // 0 -> 0 (self-loop)
        assertEquals(1, StronglyConnectedComponents.kosaraju(1, adj));
    }

    // Test 6: Multiple SCCs (integration-level: graph reversal mutation)
    @Test
    public void testMultipleSCCs() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1)));  // 0 -> 1
        adj.add(new ArrayList<>(Arrays.asList(2)));  // 1 -> 2
        adj.add(new ArrayList<>(Arrays.asList(0)));  // 2 -> 0
        adj.add(new ArrayList<>(Arrays.asList(4)));  // 3 -> 4
        adj.add(new ArrayList<>(Arrays.asList(3)));  // 4 -> 3
        assertEquals(2, StronglyConnectedComponents.kosaraju(5, adj));
    }

    // Test 7: Complete graph (unit-level: arithmetic mutation)
    @Test
    public void testCompleteGraph() {
        int n = 3;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j) adj.get(i).add(j);
            }
        }
        assertEquals(1, StronglyConnectedComponents.kosaraju(n, adj));
    }

    // Test 8: Empty graph (integration-level: edge case mutation)
    @Test
    public void testEmptyGraph() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        assertEquals(0, StronglyConnectedComponents.kosaraju(0, adj));
    }

    // Test 9: Star graph (integration-level: method call mutation)
    @Test
    public void testStarGraph() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());  // Center node with no outgoing edges
        adj.add(new ArrayList<>(Arrays.asList(0)));  // Node 1 -> 0
        adj.add(new ArrayList<>(Arrays.asList(0)));  // Node 2 -> 0
        assertEquals(3, StronglyConnectedComponents.kosaraju(3, adj));
    }

    // Test 10: Graph with bidirectional edges (unit-level: loop mutation)
    @Test
    public void testBidirectionalEdges() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));  // 0 -> 1, 2
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));  // 1 -> 0, 2
        adj.add(new ArrayList<>(Arrays.asList(0, 1)));  // 2 -> 0, 1
        assertEquals(1, StronglyConnectedComponents.kosaraju(3, adj));
    }

}