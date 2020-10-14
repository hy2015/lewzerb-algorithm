package com.lewzerb.leetcode;

import java.util.List;

public class Leetcode0024 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        Leetcode0024 leetcode0024 = new Leetcode0024();
        ListNode nL = leetcode0024.swapPairs(l1);
        ListNode.print(nL);
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }
}
