package top100.LinkedList;

import common.ListNode;

public class Solution19 {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNodebyList(new int[]{1, 2});
        int n = 2;
        ListNode listNode = new Solution19().removeNthFromEnd(head, n);
        ListNode.printList(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        ListNode p = dummy;
        for (int i = 0; i < len - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
