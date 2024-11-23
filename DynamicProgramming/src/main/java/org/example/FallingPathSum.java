package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FallingPathSum {
    static int getMaxPathSum(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            prev.set(j, matrix.get(0).get(j));
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix.get(i).get(j) + prev.get(j);

                int leftDiagonal = matrix.get(i).get(j);
                if (j - 1 >= 0) {
                    leftDiagonal += prev.get(j - 1);
                } else {
                    leftDiagonal += -1e9;
                }

                int rightDiagonal = matrix.get(i).get(j);
                if (j + 1 < m) {
                    rightDiagonal += prev.get(j + 1);
                } else {
                    rightDiagonal += -1e9;
                }
                // Store the maximum of the three paths in cur
                cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
            }
            // Update the prev list with the values from the cur list for the next row
            prev = new ArrayList<>(cur);
        }

        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev.get(j));
        }
        return maxi;
    }
}
