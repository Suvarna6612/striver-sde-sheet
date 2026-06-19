import java.util.*;

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        return solve(s, set, 0);
    }

    private boolean solve(String s, HashSet<String> set, int index) {

        if (index == s.length()) {
            return true;
        }

        for (int i = index + 1; i <= s.length(); i++) {

            String word = s.substring(index, i);

            if (set.contains(word)) {

                if (solve(s, set, i)) {
                    return true;
                }
            }
        }

        return false;
    }
}