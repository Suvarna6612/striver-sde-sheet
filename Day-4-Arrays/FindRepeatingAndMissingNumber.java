class Solution {

    public int[] findMissingRepeatingNumbers(int[] nums) {

        int n = nums.length;

        long sumN = (long)n * (n + 1) / 2;

        long sumSqN =
            (long)n * (n + 1) * (2L * n + 1) / 6;

        long actualSum = 0;
        long actualSqSum = 0;

        for(int num : nums) {

            actualSum += num;

            actualSqSum += (long)num * num;
        }

        // x - y
        long diff1 = actualSum - sumN;

        // x² - y²
        long diff2 = actualSqSum - sumSqN;

        // x + y
        long sumXY = diff2 / diff1;

        // repeating number
        int repeating =
            (int)((diff1 + sumXY) / 2);

        // missing number
        int missing =
            (int)(sumXY - repeating);

        return new int[]{repeating, missing};
    }
}