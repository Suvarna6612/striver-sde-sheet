import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
    }
}
class Solution {

    public List<Integer> floorCeilOfBST(TreeNode root, int key) {

        int floor = -1;
        int ceil = -1;

        TreeNode curr = root;

        // Find Floor
        while (curr != null) {
            if (curr.data == key) {
                floor = curr.data;
                break;
            } else if (curr.data > key) {
                curr = curr.left;
            } else {
                floor = curr.data;
                curr = curr.right;
            }
        }

        curr = root;

        // Find Ceil
        while (curr != null) {
            if (curr.data == key) {
                ceil = curr.data;
                break;
            } else if (curr.data < key) {
                curr = curr.right;
            } else {
                ceil = curr.data;
                curr = curr.left;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(floor);
        ans.add(ceil);

        return ans;
    }
}