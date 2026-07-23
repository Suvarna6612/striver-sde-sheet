
class Solution {

    public int maxSumIncreasingSubsequence(int[] arr, int n) {

        int[] dp = new int[n];

        int maxSum = 0;

        for (int i = 0; i < n; i++) {

            dp[i] = arr[i];

            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }

            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}