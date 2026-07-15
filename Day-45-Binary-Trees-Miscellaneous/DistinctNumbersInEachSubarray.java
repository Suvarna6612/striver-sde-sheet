import java.util.*;

class Solution {

    public List<Integer> distinctNumbers(int[] nums, int k) {

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequency = new HashMap<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            frequency.put(nums[right],
                    frequency.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 == k) {

                result.add(frequency.size());

                frequency.put(nums[left], frequency.get(nums[left]) - 1);

                if (frequency.get(nums[left]) == 0) {
                    frequency.remove(nums[left]);
                }

                left++;
            }
        }

        return result;
    }
}