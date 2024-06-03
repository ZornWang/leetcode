package top100.LinkedList;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 * 给你两个单链表的头节点 headA 和 headB
 * 请你找出并返回两个单链表相交的起始节点
 * 如果两个链表不存在相交节点，返回 null
 */

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> hashSet = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
