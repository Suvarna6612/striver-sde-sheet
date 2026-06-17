import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int index, int[] candidates, int target,
                       List<Integer> curr,
                       List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }

        // Pick
        curr.add(candidates[index]);

        solve(index,
              candidates,
              target - candidates[index],
              curr,
              ans);

        curr.remove(curr.size() - 1);

        // Not Pick
        solve(index + 1,
              candidates,
              target,
              curr,
              ans);
    }
}