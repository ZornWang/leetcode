package top100.LinkedList;

import common.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution138 {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Map<Integer, Node> newNodeMap = new HashMap<>();
        Map<Node, Integer> oldNodeMap = new HashMap<>();
        Node p = head;
        int n = 0;
        while (p != null) {
            newNodeMap.put(n, new Node(p.val));
            oldNodeMap.put(p, n);
            n++;
            p = p.next;
        }
        Node copy = new Node(-1);
        Node cur = copy;
        for (int i = 0; i < newNodeMap.size(); i++) {
            cur.next = newNodeMap.get(i);
            cur = cur.next;
        }
        cur = copy;
        p = head;
        while (p != null) {
            cur.next.random = newNodeMap.get(oldNodeMap.get(p.random));
            p = p.next;
            cur = cur.next;
        }

        return copy.next;
    }
}
