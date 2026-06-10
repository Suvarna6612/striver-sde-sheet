class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public void deleteNodeInLinkedList(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
}