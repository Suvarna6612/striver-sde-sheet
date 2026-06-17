import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int start, int[] arr, int target,
                       List<Integer> curr,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            curr.add(arr[i]);

            solve(i + 1, arr, target - arr[i], curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}