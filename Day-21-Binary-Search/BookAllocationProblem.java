class Solution {

    public int findPages(int[] nums, int m) {

        int n = nums.length;

        if (m > n) return -1;

        int low = 0;
        int high = 0;

        for (int pages : nums) {
            low = Math.max(low, pages);
            high += pages;
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canAllocate(nums, m, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canAllocate(int[] nums, int m, int maxPages) {

        int students = 1;
        int pagesSum = 0;

        for (int pages : nums) {

            if (pagesSum + pages <= maxPages) {
                pagesSum += pages;
            } else {
                students++;
                pagesSum = pages;

                if (students > m) {
                    return false;
                }
            }
        }

        return true;
    }
}