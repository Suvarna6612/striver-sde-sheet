class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

class Solution {

    public Node connect(Node root) {

        if (root == null)
            return null;

        Node leftMost = root;

        while (leftMost.left != null) {

            Node curr = leftMost;

            while (curr != null) {

                curr.left.next = curr.right;

                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }
}