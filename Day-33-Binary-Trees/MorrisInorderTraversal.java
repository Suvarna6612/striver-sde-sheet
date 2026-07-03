
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> getInorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // Case 1: No left child
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }

            // Case 2: Left child exists
            else {

                TreeNode prev = curr.left;

                // Find inorder predecessor
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create thread
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }

                // Thread already exists
                else {
                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}