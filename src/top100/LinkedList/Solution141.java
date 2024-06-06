package top100.LinkedList;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {
    public static void main(String[] args) {

    }

    // 快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    // hash表
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> hashSet = new HashSet<>();
//        ListNode p = head;
//        while (p != null) {
//            if (hashSet.contains(p)) {
//                return true;
//            } else {
//                hashSet.add(p);
//                p = p.next;
//            }
//        }
//        return false;
//    }
}
