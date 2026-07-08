import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int left, int right) {

        if (left > right)
            return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int mid = map.get(rootValue);

        // Build right subtree first
        root.right = build(postorder, mid + 1, right);

        // Then left subtree
        root.left = build(postorder, left, mid - 1);

        return root;
    }
}