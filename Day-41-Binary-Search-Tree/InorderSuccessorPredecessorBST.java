import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> succPredBST(TreeNode root, int key) {

        int pred = -1;
        int succ = -1;

        TreeNode curr = root;

        while (curr != null) {

            if (key < curr.val) {
                succ = curr.val;
                curr = curr.left;
            }
            else if (key > curr.val) {
                pred = curr.val;
                curr = curr.right;
            }
            else {

                TreeNode left = curr.left;
                while (left != null) {
                    pred = left.val;
                    left = left.right;
                }

                TreeNode right = curr.right;
                while (right != null) {
                    succ = right.val;
                    right = right.left;
                }

                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(pred);
        ans.add(succ);

        return ans;
    }
}