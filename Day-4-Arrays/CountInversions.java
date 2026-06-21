
import java.util.ArrayList;


class Solution {

    public long numberOfInversions(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    public long mergeSort(int[] nums,
                          int low,
                          int high) {

        long count = 0;

        if(low >= high) {
            return count;
        }

        int mid = (low + high) / 2;

        count += mergeSort(nums, low, mid);

        count += mergeSort(nums, mid + 1, high);

        count += merge(nums, low, mid, high);

        return count;
    }

    public long merge(int[] nums,
                      int low,
                      int mid,
                      int high) {

        ArrayList<Integer> temp =
            new ArrayList<>();

        int left = low;
        int right = mid + 1;

        long count = 0;

        while(left <= mid && right <= high) {

            if(nums[left] <= nums[right]) {

                temp.add(nums[left]);

                left++;
            }
            else {

                temp.add(nums[right]);

                count += (mid - left + 1);

                right++;
            }
        }

        while(left <= mid) {

            temp.add(nums[left]);

            left++;
        }

        while(right <= high) {

            temp.add(nums[right]);

            right++;
        }

        for(int i = low; i <= high; i++) {

            nums[i] = temp.get(i - low);
        }

        return count;
    }
}