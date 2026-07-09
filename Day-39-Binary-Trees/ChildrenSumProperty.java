class Solution {

    boolean checkChildrenSum(TreeNode root) {

        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int left = 0;
        int right = 0;

        if (root.left != null)
            left = root.left.val;

        if (root.right != null)
            right = root.right.val;

        if (root.val != left + right)
            return false;

        return checkChildrenSum(root.left) &&
               checkChildrenSum(root.right);
    }
}