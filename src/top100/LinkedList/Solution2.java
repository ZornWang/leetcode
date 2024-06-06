package top100.LinkedList;

import common.ListNode;

public class Solution2 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNodebyList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.getListNodebyList(new int[]{5, 6, 4});
        ListNode result = new Solution2().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, p = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (result == null) {
                result = p = new ListNode(sum % 10);
            } else {
                p.next = new ListNode(sum % 10);
                p = p.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return result;
    }
}
