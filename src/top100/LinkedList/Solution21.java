package top100.LinkedList;

import common.ListNode;

public class Solution21 {
    public static void main(String[] args) {
        int[] list1 = {1, 2, 4};
        int[] list2 = {1, 3, 4};
        ListNode a = new ListNode();
        ListNode.getListNodebyList(a, list1);
        ListNode b = new ListNode();
        ListNode.getListNodebyList(b, list2);
        ListNode merge = new Solution21().mergeTwoLists(a, b);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(-1);
        ListNode p = merge;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        p.next = list1 == null ? list2 : list1;
        return merge.next;
    }
}
