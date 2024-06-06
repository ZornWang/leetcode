package top100.LinkedList;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (!set.add(p)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
