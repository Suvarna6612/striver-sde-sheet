import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        postorder(root);
        return ans;
    }

    private void postorder(TreeNode node) {

        if (node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        ans.add(node.val);
    }
}