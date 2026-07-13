import java.util.*;

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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (!values[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < values.length && !values[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}