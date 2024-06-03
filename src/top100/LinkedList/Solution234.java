package top100.LinkedList;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution234 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode.getListNodebyList(head, new int[]{1, 2, 2, 1});
        System.out.println(new Solution234().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int n = list.size();
        if (n == 0) {
            return false;
        }
        for (int i = 0; i < (n / 2 + 1); i++) {
            if (!Objects.equals(list.get(i), list.get(n - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
