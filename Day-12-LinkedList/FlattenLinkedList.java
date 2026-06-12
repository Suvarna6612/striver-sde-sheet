class ListNode {
    int data;
    ListNode next;
    ListNode child;

     ListNode(int data) {
        this.data = data;
    }
}
class FlattenLinkedList {

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (a != null && b != null) {

            if (a.data <= b.data) {
                temp.child = a;
                a = a.child;
            } else {
                temp.child = b;
                b = b.child;
            }

            temp = temp.child;
        }

        if (a != null) temp.child = a;
        if (b != null) temp.child = b;

        return dummy.child;
    }

    public ListNode flattenLinkedList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        head.next = flattenLinkedList(head.next);

        head = merge(head, head.next);

        return head;
    }
}