package com.lewzerb.leetcode;

public class Leetcode0083 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur.next != null){
            if(cur.val != cur.next.val){
                pre.next = cur;
                pre = pre.next;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}
