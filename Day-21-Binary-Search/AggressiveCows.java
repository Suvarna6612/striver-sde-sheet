import java.util.Arrays;

class Solution {

    public int aggressiveCows(int[] nums, int k) {

        Arrays.sort(nums);

        int low = 1;
        int high = nums[nums.length - 1] - nums[0];

        int answer = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlace(nums, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canPlace(int[] nums, int k, int distance) {

        int cowsPlaced = 1;
        int lastPosition = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] - lastPosition >= distance) {

                cowsPlaced++;
                lastPosition = nums[i];

                if (cowsPlaced >= k) {
                    return true;
                }
            }
        }

        return false;
    }
}