package org.example;

public class MaxNonAdjSum {
    public static int solve(int n, int[] arr) {
        // Initialize variables to keep track of the maximum sums at the current and previous positions.
        int prev = arr[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;

            int nonPick = prev;
            int cur_i = Math.max(pick, nonPick);

            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }
}
