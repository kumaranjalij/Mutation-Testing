package org.example;

import java.util.Arrays;

public class FrogJump {
    public static int solveUtil(int n, int[] height, int[] dp, int k) {
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int mmSteps = Integer.MAX_VALUE;

            // Loop to try all possible jumps from '1' to 'k'
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(jump, mmSteps);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1]; // The result is stored in the last element of dp
    }
    // Function to find the minimum cost to reach the end of the array
    static int solve(int n, int[] height, int k) {
        int[] dp = new int[n]; // Initialize a memoization array to store calculated results
        Arrays.fill(dp, -1);
        return solveUtil(n, height, dp, k);
    }
}