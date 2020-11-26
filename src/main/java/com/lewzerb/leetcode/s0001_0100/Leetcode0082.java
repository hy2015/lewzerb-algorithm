package com.lewzerb.leetcode.s0001_0100;

import com.lewzerb.leetcode.ListNode;

public class Leetcode0082 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur!=null && cur.next != null){
           if( pre.next.val != cur.next.val ){
               pre = pre.next;
           }else {
               while (cur.next != null && pre.next.val == cur.next.val){
                   cur = cur.next;
               }
               pre.next = cur.next;
           }
            cur = cur.next;

        }
        return dummy.next;
    }
}
