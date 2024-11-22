package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Mutation Operators Used:
//
//Arithmetic Operator Replacement (AOR): Replace arithmetic operations (+, -, *, /, %) with other operations.
//Relational Operator Replacement (ROR): Change relational operators (>=, >, <=, <) to other relational operators.
//Conditional Boundary Mutation (CBM): Modify loop boundaries and conditional statements.
//Logical Connector Mutation (LCM): Replace logical connectors (&&, ||) with their opposites.
//Increment/Decrement Mutation (IDM): Modify increment/decrement operations (++, --).
//Statement Deletion Mutation (SDM): Remove important statements.

class LargestRectangleInHistogramTest {

//    Checks basic functionality. AOR: Change * to + in maxA = Math.max(maxA, width * height).
    @Test
    void testBaseCaseWithPositiveElements() {
        int histo[] = {3, 1, 5, 6, 2, 3};
        assertEquals(10, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Tests for identical bars. ROR: Change >= to > in the while loop.
    @Test
    void testAllElementsEqual() {
        int histo[] = {2, 2, 2, 2, 2};
        assertEquals(10, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Verifies handling of a single bar. IDM: Remove st.push(i); after the while loop.
    @Test
    void testSingleElement() {
        int histo[] = {7};
        assertEquals(7, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Ensures proper handling of descending heights. CBM: Change i <= n to i < n.
    @Test
    void testDescendingOrderBars() {
        int histo[] = {5, 4, 3, 2, 1};
        assertEquals(9, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Complex shape with peaks and valleys. SDM: Remove st.pop(); inside the while loop.
    @Test
    void testMixedHeightsWithPeak() {
        int histo[] = {2, 1, 5, 6, 2, 3, 1};
        assertEquals(10, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Tests increasing bar heights. LCM: Replace && with || in while loop condition.
    @Test
    void testAscendingOrderBars() {
        int histo[] = {1, 2, 3, 4, 5};
        assertEquals(9, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Edge case with no bars. ROR: Replace >= with <
    @Test
    void testEmptyHistogram() {
        int histo[] = {};
        assertEquals(0, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Tests for large values. AOR: Change width * height to width / height.
    @Test
    void testLargeHeights() {
        int histo[] = {1000, 1000, 1000};
        assertEquals(3000, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//     Random bar heights. LCM: Replace !st.empty() with st.empty() in while.
    @Test
    void testRandomHeights() {
        int histo[] = {3, 2, 1, 4, 5, 3, 3, 2};
        assertEquals(12, LargestRectangleInHistogram.largestRectangleArea(histo));
    }

//    Tests performance with large input. CBM: Modify loop boundary i <= n to i < n.
    @Test
    void testLargeArraySize() {
        int[] histo = new int[10000];  // Array of size 10,000 with all elements as 1
        for (int i = 0; i < histo.length; i++) {
            histo[i] = 1;
        }
        int expected = 10000;  // The largest rectangle area in this case is the whole array
        assertEquals(expected, LargestRectangleInHistogram.largestRectangleArea(histo),
                "Failed on large array size test case");
    }

}