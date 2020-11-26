package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.ListNode;

public class Leetcode0086 {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead, after = afterHead;

        while (head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;

        before.next = afterHead.next;
        return beforeHead.next;
    }
}
