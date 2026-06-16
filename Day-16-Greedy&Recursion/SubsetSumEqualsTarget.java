class Solution {

    public boolean isSubsetSum(int[] arr, int target) {
        return solve(0, arr, target);
    }

    private boolean solve(int index, int[] arr, int target) {

        if (target == 0) {
            return true;
        }

        if (index == arr.length) {
            return false;
        }

        // Take current element
        if (arr[index] <= target) {
            if (solve(index + 1, arr, target - arr[index])) {
                return true;
            }
        }

        // Don't take current element
        return solve(index + 1, arr, target);
    }
}
