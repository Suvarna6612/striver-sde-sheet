import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> inorder = new ArrayList<>();

    public List<Integer> kLargesSmall(TreeNode root, int k) {

        inorderTraversal(root);

        int n = inorder.size();

        List<Integer> ans = new ArrayList<>();
        ans.add(inorder.get(k - 1));     // kth smallest
        ans.add(inorder.get(n - k));     // kth largest

        return ans;
    }

    private void inorderTraversal(TreeNode root) {

        if (root == null)
            return;

        inorderTraversal(root.left);
        inorder.add(root.data);
        inorderTraversal(root.right);
    }
}