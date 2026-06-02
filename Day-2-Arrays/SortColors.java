class Solution {

    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {

            // Case 1: 0
            if(nums[mid] == 0) {

                swap(nums, low, mid);

                low++;
                mid++;
            }

            // Case 2: 1
            else if(nums[mid] == 1) {

                mid++;
            }

            // Case 3: 2
            else {

                swap(nums, mid, high);

                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}