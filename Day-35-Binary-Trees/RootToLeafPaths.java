
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    public List<List<Integer>> allRootToLeaf(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(root, path, ans);

        return ans;
    }

    private void dfs(TreeNode node, List<Integer> path, List<List<Integer>> ans) {

        if (node == null)
            return;

        path.add(node.val);

        // Leaf node
        if (node.left == null && node.right == null) {

            ans.add(new ArrayList<>(path));

        } else {

            dfs(node.left, path, ans);
            dfs(node.right, path, ans);

        }

        // Backtracking
        path.remove(path.size() - 1);
    }
}