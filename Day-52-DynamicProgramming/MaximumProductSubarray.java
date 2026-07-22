class Solution {

    public int maxProduct(int[] nums) {

        int prefix = 1;
        int suffix = 1;

        int answer = Integer.MIN_VALUE;

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            answer = Math.max(answer, Math.max(prefix, suffix));
        }

        return answer;
    }
}