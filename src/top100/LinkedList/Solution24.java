package top100.LinkedList;

import common.ListNode;


public class Solution24 {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNodebyList(new int[]{1, 2, 3, 4});
        ListNode swapped = new Solution24().swapPairs(head);
        ListNode.printList(swapped);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode tmp1 = cur.next;
            ListNode tmp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = tmp1;
            cur.next.next.next = tmp2;

            cur = cur.next.next;
        }
        return dummy.next;
    }
}
