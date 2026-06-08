
import java.util.HashSet;

class Solution {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // store all elements in set
        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for(int num : set) {

            // start of sequence
            if(!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // count consecutive numbers
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}