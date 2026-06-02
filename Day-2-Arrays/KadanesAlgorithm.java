class Solution {

    public int maxSubArray(int[] nums) {

        int sum = 0;

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {

            // Add current element to running sum
            sum += nums[i];

            // Update maximum sum
            maxSum = Math.max(maxSum, sum);

            // Reset if sum becomes negative
            if(sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}