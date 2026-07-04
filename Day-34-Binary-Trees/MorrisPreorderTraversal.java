
import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> preorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // No left child
            if (curr.left == null) {

                ans.add(curr.data);
                curr = curr.right;
            }

            else {

                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                // Create thread
                if (prev.right == null) {

                    ans.add(curr.data);     // Visit BEFORE going left
                    prev.right = curr;
                    curr = curr.left;
                }

                // Remove thread
                else {

                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}