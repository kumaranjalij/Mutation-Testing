package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Logical Negation Mutation: Changes condition checks (e.g., == to !=).
//Arithmetic Operator Mutation: Alters mathematical operations (e.g., + to -).
//Boundary Condition Mutation: Modifies loop boundaries.
//Initialization Mutation: Changes initial values for arrays or variables.
//Self-loop Handling Mutation: Alters logic handling self-referential edges.

class BellmanFordTest {

//    Logical Negation Mutation (if (dist[u] + wt < dist[v]) to if (dist[u] + wt > dist[v])).
//    Explanation: Ensures distances are minimized correctly.
    @Test
    void testPositiveEdges() {
        int V = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 4)),
                new ArrayList<>(Arrays.asList(1, 2, 3))
        ));
        int[] expected = {0, 4, 7};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Arithmetic Operator Mutation (dist[v] = dist[u] + wt to dist[v] = dist[u] - wt).
//    Explanation: Validates correct addition of edge weights, especially with negatives.
    @Test
    void testNegativeEdge() {
        int V = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 1)),
                new ArrayList<>(Arrays.asList(1, 2, -2))
        ));
        int[] expected = {0, 1, -1};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Loop Boundary Mutation (for (int i = 0; i < V - 1; i++) to for (int i = 0; i < V; i++)).
//    Explanation: Checks if an extra relaxation step detects negative cycles.
    @Test
    void testNegativeCycleDetection() {
        int V = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 1)),
                new ArrayList<>(Arrays.asList(1, 2, -1)),
                new ArrayList<>(Arrays.asList(2, 0, -1))
        ));
        int[] expected = {-1}; // Indicates a negative cycle
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Variable Replacement Mutation (change dist[v] = dist[u] + wt to dist[v] = dist[u] + 1).
//    Explanation: Ensures correct distance calculation for large graphs.
    @Test
    void testLargeGraph() {
        int V = 5;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 10)),
                new ArrayList<>(Arrays.asList(1, 2, 20)),
                new ArrayList<>(Arrays.asList(2, 3, 30)),
                new ArrayList<>(Arrays.asList(3, 4, 40))
        ));
        int[] expected = {0, 10, 30, 60, 100};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Initialization Mutation (dist[i] = (int)(1e8) to dist[i] = 0).
//    Explanation: Checks initialization of unreachable nodes.
    @Test
    void testDisconnectedGraph() {
        int V = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, 1))
        ));
        int[] expected = {0, 1, 100000000, 100000000};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Self-loop Handling Mutation (ignore self-loops in relaxation).
//    Explanation: Validates self-loop behavior.
    @Test
    void testSelfLoop() {
        int V = 2;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 0, 1))
        ));
        int[] expected = {0, 100000000};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//     Boundary Condition Mutation (skip empty graph checks).
//    Explanation: Ensures correct handling of a single vertex.
    @Test
    void testSingleNode() {
        int V = 1;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int[] expected = {0};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Edge Case Mutation (V-1 relaxations altered).
//    Explanation: Tests correct handling of negative edges without cycles.
    @Test
    void testNegativeEdgeNoCycle() {
        int V = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(0, 1, -1)),
                new ArrayList<>(Arrays.asList(1, 2, 2)),
                new ArrayList<>(Arrays.asList(2, 3, 3))
        ));
        int[] expected = {0, -1, 1, 4};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

//    Empty Edge Handling Mutation (change loop to if (edges.size() > 0)).
//    Explanation: Checks behavior with no edges.
    @Test
    void testAllNodesUnreachable() {
        int V = 3;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int[] expected = {0, 100000000, 100000000};
        assertArrayEquals(expected, BellmanFord.bellman_ford(V, edges, 0));
    }

}