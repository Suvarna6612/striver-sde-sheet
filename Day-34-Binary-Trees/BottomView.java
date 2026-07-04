
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class BottomView {

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            TreeNode node = curr.node;
            int hd = curr.hd;

            // Always overwrite for Bottom View
            map.put(hd, node.data);

            if (node.left != null)
                q.offer(new Pair(node.left, hd - 1));

            if (node.right != null)
                q.offer(new Pair(node.right, hd + 1));
        }

        for (int value : map.values())
            ans.add(value);

        return ans;
    }
}