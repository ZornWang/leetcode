package top100.LinkedList;

import common.ListNode;


public class Solution206 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode.getListNodebyList(head, new int[]{1, 2, 3, 4, 5});
        ListNode reversed = new Solution206().reverseList(head);
        ListNode.printList(reversed);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next; // 保存p的下一个节点
            p.next = pre; // 翻转
            pre = p;
            p = temp;
        }
        return pre;
    }
}
