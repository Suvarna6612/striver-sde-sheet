import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return solve(s, set, 0, dp);
    }

    private boolean solve(String s, HashSet<String> set, int index, int[] dp) {

        if (index == s.length()) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1;
        }

        for (int i = index + 1; i <= s.length(); i++) {

            String word = s.substring(index, i);

            if (set.contains(word)) {

                if (solve(s, set, i, dp)) {
                    dp[index] = 1;
                    return true;
                }
            }
        }

        dp[index] = 0;
        return false;
    }
}