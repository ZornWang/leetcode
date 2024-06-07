package top100.LinkedList;

import common.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution148 {
    public static void main(String[] args) {
        ListNode listNode = new Solution148().sortList(ListNode.getListNodebyList(new int[]{4, 2, 1, 3}));
        ListNode.printList(listNode);
    }
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            nodes.add(p);
            p = p.next;
        }
        nodes.sort(Comparator.comparingInt(o -> o.val));
        ListNode dummy = new ListNode(-1, head);
        p = dummy;
        for (ListNode node : nodes) {
            p.next = node;
            p = p.next;
        }
        p.next = null;
        return dummy.next;
    }
}
