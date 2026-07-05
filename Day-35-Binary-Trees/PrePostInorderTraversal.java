
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Pair {
    TreeNode node;
    int state;

    Pair(TreeNode node, int state) {
        this.node = node;
        this.state = state;
    }
}

class Solution {

    List<List<Integer>> treeTraversal(TreeNode root) {

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            ans.add(in);
            ans.add(pre);
            ans.add(post);
            return ans;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {

            Pair it = st.pop();

            if (it.state == 1) {

                pre.add(it.node.val);

                it.state++;
                st.push(it);

                if (it.node.left != null)
                    st.push(new Pair(it.node.left, 1));

            }

            else if (it.state == 2) {

                in.add(it.node.val);

                it.state++;
                st.push(it);

                if (it.node.right != null)
                    st.push(new Pair(it.node.right, 1));

            }

            else {

                post.add(it.node.val);

            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }
}