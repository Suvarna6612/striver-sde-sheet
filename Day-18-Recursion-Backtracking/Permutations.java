import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, ans);

        return ans;
    }

    private void solve(int index, int[] nums, List<List<Integer>> ans) {

        if (index == nums.length) {

            List<Integer> temp = new ArrayList<>();

            for (int num : nums) {
                temp.add(num);
            }

            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Choose
            swap(nums, i, index);

            // Explore
            solve(index + 1, nums, ans);

            // Undo (Backtrack)
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}