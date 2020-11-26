package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.ListNode;

public class Leetcode0021 {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;

        Leetcode0021 leetcode0021 = new Leetcode0021();
        ListNode m = leetcode0021.mergeTwoLists(null, null);
        ListNode.print(m);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode copy = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                copy.next = l1;
                l1 = l1.next;
            } else {
                copy.next = l2;
                l2 = l2.next;
            }
            copy = copy.next;
        }

        if(l1 == null ){
            copy.next = l2;
        }
        if(l2 == null){
            copy.next = l1;
        }
        return dummy.next;
    }
}
