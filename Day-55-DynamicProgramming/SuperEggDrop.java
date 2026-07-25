import java.util.*;

class Solution {

    public int eggDrop(int n, int k) {

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(n, k, dp);
    }

    private int solve(int eggs, int floors, int[][] dp) {

        if (floors == 0 || floors == 1)
            return floors;

        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];

        int low = 1;
        int high = floors;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int eggBreaks = solve(eggs - 1, mid - 1, dp);

            int eggSurvives = solve(eggs, floors - mid, dp);

            int worstCase = 1 + Math.max(eggBreaks, eggSurvives);

            ans = Math.min(ans, worstCase);

            if (eggBreaks < eggSurvives) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return dp[eggs][floors] = ans;
    }
}