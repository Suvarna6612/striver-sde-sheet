
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public List<Integer> boundary(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        if (!isLeaf(root))
            ans.add(root.val);

        addLeftBoundary(root, ans);
        addLeaves(root, ans);
        addRightBoundary(root, ans);

        return ans;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    void addLeftBoundary(TreeNode node, List<Integer> ans) {

        TreeNode curr = node.left;

        while (curr != null) {

            if (!isLeaf(curr))
                ans.add(curr.val);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    void addLeaves(TreeNode node, List<Integer> ans) {

        if (node == null)
            return;

        if (isLeaf(node)) {
            ans.add(node.val);
            return;
        }

        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    void addRightBoundary(TreeNode node, List<Integer> ans) {

        TreeNode curr = node.right;

        Stack<Integer> st = new Stack<>();

        while (curr != null) {

            if (!isLeaf(curr))
                st.push(curr.val);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        while (!st.isEmpty())
            ans.add(st.pop());
    }
}