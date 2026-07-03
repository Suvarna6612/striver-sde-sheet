import java.util.ArrayList;
import java.util.List;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        inorder(root);

        return ans;
    }

    private void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);

        ans.add(node.val);

        inorder(node.right);
    }
}