package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Logical Negation Mutation: Alters condition checks (e.g., == to !=).
//Conditional Operator Replacement: Changes the logic of if statements.
//Boundary Mutation: Modifies loop boundaries.
//Initialization Mutation: Changes initial values or skips initializations.
//Edge Case Mutation: Introduces special cases like self-loops or cycles.
//Data Flow Mutation: Alters data structure handling (e.g., incorrect adjacency list setup).

class CourseScheduleTest {

//    Logical Negation Mutation (if (topo.size() == V) changed to if (topo.size() != V)).
//    Tests if the method correctly returns true when there’s a valid order.
    @Test
    void testSimpleDependency() {
        int N = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Conditional Operator Replacement (if (indegree[it] == 0) changed to if (indegree[it] > 0)).
//    Explanation: Detects cycles in the graph by validating indegree updates.
    @Test
    void testCircularDependency() {
        int N = 3;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 0}};
        assertFalse(CourseSchedule.isPossible(N, prerequisites));
    }

//    Initialization Mutation (adjacency list setup altered or omitted).
//    Explanation: Ensures the method handles an empty graph without errors.
    @Test
    void testNoPrerequisites() {
        int N = 3;
        int[][] prerequisites = {};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Boundary Mutation (loop for (int i = 0; i < V; i++) changed to i <= V).
//    Explanation: Checks boundary conditions for minimal input.
    @Test
    void testSingleCourse() {
        int N = 1;
        int[][] prerequisites = {};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Variable Replacement (indegree[it]-- changed to indegree[it]-=2).
//    Explanation: Ensures independent chains are processed without interaction errors.
    @Test
    void testIndependentChains() {
        int N = 6;
        int[][] prerequisites = {{1, 0}, {3, 2}, {5, 4}};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Edge Case Mutation (handling cycles in isolated components).
//    Explanation: Validates that cycles in disconnected components are detected.
    @Test
    void testDisconnectedCycle() {
        int N = 5;
        int[][] prerequisites = {{1, 0}, {2, 1}, {0, 2}, {4, 3}};
        assertFalse(CourseSchedule.isPossible(N, prerequisites));
    }

//    Performance Mutation (change queue operations to stack).
//    Explanation: Tests scalability and correct behavior with large inputs
    @Test
    void testLargeLinearChain() {
        int N = 1000;
        int[][] prerequisites = new int[N - 1][2];
        for (int i = 0; i < N - 1; i++) {
            prerequisites[i][0] = i + 1;
            prerequisites[i][1] = i;
        }
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Self-loop Handling (incorrect indegree calculation).
//    Explanation: Ensures self-loops are detected as cycles.
    @Test
    void testSelfLoop() {
        int N = 2;
        int[][] prerequisites = {{0, 0}};
        assertFalse(CourseSchedule.isPossible(N, prerequisites));
    }

//    Data Flow Mutation (incorrect initialization of adj).
//    Explanation: Validates ordering logic when prerequisites are in reverse.
    @Test
    void testReverseOrder() {
        int N = 3;
        int[][] prerequisites = {{2, 1}, {1, 0}};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

//    Duplicate Edge Handling (incorrect increment of indegree).
//    Explanation: Tests robustness when duplicates exist.
    @Test
    void testDuplicatePrerequisites() {
        int N = 4;
        int[][] prerequisites = {{1, 0}, {1, 0}, {2, 1}, {3, 2}};
        assertTrue(CourseSchedule.isPossible(N, prerequisites));
    }

}