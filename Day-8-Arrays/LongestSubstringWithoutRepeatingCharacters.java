
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Duplicate found
            if(map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            // Store latest index
            map.put(ch, right);

            // Window size
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}