
import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // If sum itself equals k
            if(sum == k) {
                maxLen = i + 1;
            }

            // Remaining sum exists
            if(map.containsKey(sum - k)) {

                int len = i - map.get(sum - k);

                maxLen = Math.max(maxLen, len);
            }

            // Store first occurrence only
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}